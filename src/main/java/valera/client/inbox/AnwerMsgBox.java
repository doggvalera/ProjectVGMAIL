package valera.client.inbox;


import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import valera.client.BaseCallback;
import valera.shared.ValeraService;
import valera.shared.ValeraServiceAsync;
import valera.shared.model.CreateMail;

/**
 * Created by valerijszemlanikins on 27.12.13.
 */
public class AnwerMsgBox extends DialogBox implements HasText {
    private ValeraServiceAsync service;

    @UiField
    public Button sendMail;
    @UiField
    public TextBox nameMail;

    @UiField
    public TextBox themName;

    @UiField
    public RichTextArea sendMailBox;
    @UiField
    public Button close;
    @UiField
    public Label labelSendName;
    @UiField
    public Label labelSendTheme;


    public String sendmail;
    protected HasDirection.Direction dir = HasDirection.Direction.DEFAULT;


    interface AnwerMsgBoxUiBinder extends UiBinder<Widget, AnwerMsgBox> {
    }

    private static AnwerMsgBoxUiBinder uiBinder = GWT.create(AnwerMsgBoxUiBinder.class);

    public AnwerMsgBox(String name) {


//            @Override
//            public void onClick(ClickEvent clickEvent) {
//          //     hide();
//            }
//        });
        // DivElement rootElement = ourUiBinder.createAndBindUi(this);
        setWidget(uiBinder.createAndBindUi(this));

        setWidget(uiBinder.createAndBindUi(this));


        service = GWT.create(ValeraService.class);
        close.addClickHandler(new CloseClickHandler());
        sendMail.addClickHandler(new sendMailHandler());
        nameMail.setText(name);



    }


    private class sendMailHandler implements ClickHandler {

        public void onClick(ClickEvent event) {

            service.sendMailAuthor(new BaseCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    sendmail = s;
                    String namemail = nameMail.getText();
                    String themname = themName.getText();
                    String sendmailbox = sendMailBox.getText();

                    CreateMail crtml = new CreateMail(sendmail, namemail, themname, sendmailbox);
                    service.sendMail(crtml, new BaseCallback<Boolean>() {

                        @Override
                        public void onSuccess(Boolean aBoolean) {
                            System.out.println("all okey");
                        }
                    });
                }
            });
        }
    }

    private class CloseClickHandler implements ClickHandler {

        public void onClick(ClickEvent event) {
            hide();


        }
    }
}