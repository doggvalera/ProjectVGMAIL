package valera.client.inbox;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import valera.client.BaseCallback;
import valera.shared.InboxService;
import valera.shared.InboxServiceAsync;
import valera.shared.ValeraService;
import valera.shared.ValeraServiceAsync;
import valera.shared.model.CreateMail;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static valera.client.inbox.AnwerMsgBox.*;

/**
 * Created by valerijszemlanikins on 18.12.13.
 */


public class InboxPanel extends Composite {


    // public static final List<CreateMail> CREATE_MAILS = Arrays.asList(new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"),
    //        new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"), new CreateMail("v", "Valera", "theme", "mail"));

    private InboxServiceAsync service = GWT.create(InboxService.class);
    private ValeraServiceAsync serviceAsync = GWT.create(ValeraService.class);
    private static InboxUiBinder uiBinder = GWT.create(InboxUiBinder.class);

    // private AnwerMsgBox answerBox = new AnwerMsgBox();
    interface InboxUiBinder extends UiBinder<Widget, InboxPanel> {
    }

    @UiField
    VerticalPanel vPanel;
    @UiField
    CellTable<CreateMail> cellTable;
    @UiField(provided = true)
    SimplePager pager;
    @UiField
    RichTextArea mailTextArea;
    @UiField
    Button answerButton;
    public String name;
    AnwerMsgBox answerBox = new AnwerMsgBox(name);
    public String sendmail;

    //  public
    //

    public InboxPanel(String question) {

        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);

        initWidget(uiBinder.createAndBindUi(this));

        //getElement().getStyle().setProperty("b");
        initTable();
        answerButton.addClickHandler(new AnswerClickHandler());

    }

    private void initTable() {
        cellTable.addColumn(new TextColumn<CreateMail>() {
            @Override
            public String getValue(CreateMail object) {
                return object.getLoginTo();
            }
        }, "Sent By");

        cellTable.addColumn(new TextColumn<CreateMail>() {
            @Override
            public String getValue(CreateMail object) {
                return object.getLoginFrom();
            }
        }, "Sent To");


        //

        serviceAsync.sendMailAuthor(new BaseCallback<String>() {
            @Override
            public void onSuccess(String s) {
                sendmail = s;
                service.getMailsTo(sendmail, new BaseCallback<List<CreateMail>>() {
                    @Override
                    public void onSuccess(List<CreateMail> result) {
                        ListDataProvider<CreateMail> dataProvider = new ListDataProvider<CreateMail>();
                        dataProvider.getList().addAll(result);
                        dataProvider.addDataDisplay(cellTable);

                        final SingleSelectionModel<CreateMail> selectionModel = new SingleSelectionModel<CreateMail>();
                        cellTable.setSelectionModel(selectionModel);
                        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
                            public void onSelectionChange(SelectionChangeEvent event) {
                                // TODO: Set mail RichTextArea with getTextMail()
                                CreateMail selected = selectionModel.getSelectedObject();
                                if (selected != null) {
                                    //Window.alert("You selected: " + selected.getTextMail());
                                    mailTextArea.setText(selected.getTextMail());
                                    name = (selected.getLoginFrom());


                                    //nameMail.setText(name);


                                }
                            }
                        });
                    }
                });
                cellTable.setWidth("100%", true);
                cellTable.setPageSize(15);

                pager.setDisplay(cellTable);
            }
        });
    }

    private class AnswerClickHandler implements ClickHandler {

        public void onClick(ClickEvent event) {

            answerBox.show();
            answerBox.center();


        }
    }

    public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
        return addDomHandler(handler, MouseOverEvent.getType());
    }
}