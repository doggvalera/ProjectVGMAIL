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
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import valera.client.BaseCallback;
import valera.server.domain.User;

import valera.shared.*;
import valera.shared.model.CreateMail;

import java.util.Date;

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

    @UiField
    public VerticalPanel vPanelDt;
    @UiField
    public TextBox timeDate;

    public DateBox dtBx = new DateBox();

   public String sendmail;
		protected Direction dir = Direction.DEFAULT;



		
		public NewMail(String question) {
          // service = GWT.create(UserService.class);
            serviceAsync = GWT.create(SendMailService.class);
			buildDisplay();



            initWidget(uiBinder.createAndBindUi(this));
            vPanelDt.add(dtBx);
            Date date = new Date();
            dtBx.setValue(date);
//
            sendMail.addClickHandler(new sendMailHandler());



        }

		private void buildDisplay() {


        }

    private class sendMailHandler implements ClickHandler {

        public void onClick(ClickEvent event) {
//            Date dateReg = new Date();
            serviceAsync.sendMailAuthor(new BaseCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    sendmail = s;
                    String namemail = nameMail.getText();
                    String themname = themName.getText();
                    String sendmailbox = sendMailBox.getText();
                    Date date = new Date();

                    CreateMail crtml = new CreateMail(sendmail, namemail, themname, sendmailbox,date);
                    serviceAsync.sendMail(crtml, new BaseCallback<Boolean>() {

                        @Override
                        public void onSuccess(Boolean aBoolean) {
                            if(aBoolean==true){
                            System.out.println("all okey");
                            nameMail.setText("Messages has been sent");
                            themName.setText("");
                            sendMailBox.setText("");}

                            else  { nameMail.setText("Messages has not been sent"); }
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