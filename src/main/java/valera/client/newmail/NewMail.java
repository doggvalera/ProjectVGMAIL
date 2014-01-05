package valera.client.newmail;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import valera.client.BaseCallback;
import valera.server.domain.User;

import valera.shared.*;
import valera.shared.model.CreateMail;

public class NewMail extends Composite 	/* implements HasText, HasDirection  */ {

   private SendMailServiceAsync serviceAsync;
    private static NewMailUiBinder uiBinder = GWT
            .create(NewMailUiBinder.class);

    interface NewMailUiBinder extends UiBinder<Widget, NewMail> {
    }


    @UiField
    public Button sendMail;
    @UiField
    public TextBox nameMail;

    @UiField
    public TextBox themName;

    @UiField
    public RichTextArea sendMailBox;



   public String sendmail;
		protected Direction dir = Direction.DEFAULT;



		
		public NewMail(String question) {
          // service = GWT.create(ValeraService.class);
            serviceAsync = GWT.create(SendMailService.class);
			buildDisplay();



            initWidget(uiBinder.createAndBindUi(this));
            //this.getElement().getStyle()
                   // .setProperty("border", "solid 1px");
            sendMail.addClickHandler(new sendMailHandler());



        }

		private void buildDisplay() {



        }

    private class sendMailHandler implements ClickHandler {

        public void onClick(ClickEvent event) {

            serviceAsync.sendMailAuthor(new BaseCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    sendmail = s;
                    String namemail = nameMail.getText();
                    String themname = themName.getText();
                    String sendmailbox = sendMailBox.getText();

                    CreateMail crtml = new CreateMail(sendmail, namemail, themname, sendmailbox);
                    serviceAsync.sendMail(crtml, new BaseCallback<Boolean>() {

                        @Override
                        public void onSuccess(Boolean aBoolean) {
                            System.out.println("all okey");
                            nameMail.setText("Message has been sent");
                            themName.setText("");
                            sendMailBox.setText("");
                        }
                    });
                }
            });
        }
    }

		public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
			return addDomHandler(handler, MouseOverEvent.getType());
		}

	}