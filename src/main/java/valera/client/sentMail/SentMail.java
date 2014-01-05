package valera.client.sentMail;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import valera.client.BaseCallback;
import valera.client.inbox.AnwerMsgBox;
import valera.shared.*;
import valera.shared.model.CreateMail;

import java.util.List;


public class SentMail extends Composite  {


    private InboxServiceAsync service = GWT.create(InboxService.class);
    private ValeraServiceAsync serviceAsync= GWT.create(ValeraService.class);
    private SentMailServiceAsync serviceSent = GWT.create(SentMailService.class);
    private static SentMailUiBinder uiBinder = GWT.create(SentMailUiBinder.class);



    // private AnwerMsgBox answerBox = new AnwerMsgBox();
    interface SentMailUiBinder extends UiBinder<Widget, SentMail> {
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

    public SentMail() {

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
                serviceSent.getMailsFrom(sendmail, new BaseCallback<List<CreateMail>>() {
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

                                    System.out.println(name + "blat");
                                    //nameMail.setText(name);


                                }
                            }
                        });
                    }
                });
                System.out.println(name + "blat");
                cellTable.setWidth("100%", true);
                cellTable.setPageSize(15);


                pager.setDisplay(cellTable);
                answerBox.nameMail.setText(name);



            }
        });
    }

    private class AnswerClickHandler implements ClickHandler {

        public void onClick(ClickEvent event) {
            answerBox.nameMail.setText(name);
            answerBox.show();
            answerBox.center();


        }
    }

    public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
        return addDomHandler(handler, MouseOverEvent.getType());
    }
}
