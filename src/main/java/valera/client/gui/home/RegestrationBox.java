package valera.client.gui.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import valera.client.BaseCallback;
import valera.shared.UserService;
import valera.shared.UserServiceAsync;
import valera.shared.model.UserRegistration;

public class RegestrationBox extends DialogBox implements HasText {
    private UserServiceAsync service;
    private static RegestrationBoxUiBinder uiBinder = GWT
            .create(RegestrationBoxUiBinder.class);

    interface RegestrationBoxUiBinder extends UiBinder<Widget, RegestrationBox> {
    }

    public RegestrationBox() {
        setWidget(uiBinder.createAndBindUi(this));

        setWidget(uiBinder.createAndBindUi(this));
        service = GWT.create(UserService.class);

        this.registerNew.addClickHandler(new RegisterClickHandler());
        this.closeBtn.addClickHandler(new CloseHandler());
    }

    @UiField
    Button registerNew;
    @UiField
    TextBox name;
    @UiField
    TextBox login;
    @UiField
    TextBox surname;
    @UiField
    Label loginLabel;
    @UiField
    Label passwordLabel;
    @UiField
    Label nameLabel;
    @UiField
    Label surNameLabel;
    @UiField
    VerticalPanel vPanelReg;
    @UiField
    PasswordTextBox password;
    @UiField
    PasswordTextBox passwordRepeat;
    @UiField
    Label passwordLabelRepeat;
    @UiField
    Button closeBtn;
    @UiField
    Label error;
    //	this.registerNew.addClickHandler(new RegisterNewCkickHandler());

    private class RegisterClickHandler implements ClickHandler {

                public void onClick(ClickEvent event) {
                    String name1 = name.getText();
                    String login1 = login.getText();
                    String surname1 = surname.getText();
                    String password1 = password.getText();
                    String passwordRepat = passwordRepeat.getText();


            UserRegistration reg = new UserRegistration(name1, login1, surname1, password1, passwordRepat);

            service.register(reg, new BaseCallback<Boolean>() {
                @Override
                public void onSuccess(Boolean userExist) {
                    // TODO: need to show if user exist.
                    if (userExist == true){
                    name.setText("");
                    login.setText("");
                    surname.setText("");
                    password.setText("");
                    passwordRepeat.setText("");
                        error.setVisible(false);
                    }
                    else {error.setText("Error");
                    error.setVisible(true);}
                }
            });
        }
    }
    private class CloseHandler implements ClickHandler {

        public void onClick(ClickEvent event) {
            String name1 = name.getText();
            String login1 = login.getText();
            String surname1 = surname.getText();
            String password1 = password.getText();
            hide();
}
    }
}