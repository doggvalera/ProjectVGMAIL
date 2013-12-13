package valera.client.gui.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.Window.ClosingHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import valera.client.FlowControl;
import valera.client.ValeraGmailMain;
import valera.shared.ValeraService;
import valera.shared.ValeraServiceAsync;

public class HomePage extends Composite implements ValueChangeHandler<String> {
	private ValeraServiceAsync service;

//	private DialogBox dialogBoxRegistration = new DialogBox();
	
	@UiField
	Button loginEnter;
	
	@UiField
	Button button;
	@UiField 
	TextBox loginE;
	
//	@UiField
//	Button registerNew;
//	@UiField
//	 TextBox name;
//	@UiField
//	 TextBox login; 
//	@UiField
//	 TextBox surname; 
//	@UiField 
//	Button register; 
	
	@UiField
	PasswordTextBox passbox;


	 RegestrationBox dialogBoxRegistration = new RegestrationBox();
	
	 VerticalPanel vPanel = new VerticalPanel();
	 VerticalPanel vPanelReg = new VerticalPanel();

	 
	public HomePage() {
		//initWidget(this.vPanelReg);
		
		initWidget(uiBinder.createAndBindUi(this));
		
		service = GWT.create(ValeraService.class);
		loginEnter.addClickHandler(new LoginEnterClickHandler());
		button.addClickHandler(new RegisterNewCkickHandler());
//		this.dialogBoxRegistration.add(vPanel);
//		this.vPanel.add(name);
//		this.vPanel.add(login);
//		this.vPanel.add(surname);
//		this.vPanel.add(register);
//		
//		this.vPanelReg.add(registerNew);
//		this.register.addClickHandler(new RegisterClickHandler());
//		this.registerNew.addClickHandler(new RegisterNewCkickHandler());
//		dialogBoxRegistration.setText("Registration");
//		dialogBoxRegistration.setAnimationEnabled(true);
	//	RootPanel.get().add(loginEnter);

		// Button search = Button.wrap(DOM.getElementById("search"));

		
	}

//
//	private class RegisterClickHandler implements ClickHandler {
//
//		public void onClick(ClickEvent event) {
//			String name1 = name.getText();
//			String login1 = login.getText();
//			String surname1 = surname.getText();
//
//			service.getUserRegistration(login1, name1, surname1,
//					new BaseCallback<UserRegistration>() {
//
//						public void onSuccess(UserRegistration result) {
//							name.setText(result.getLogin());
//						}
//					});
//			name.setText("Work");
//
//		}
//
//	}

	private class RegisterNewCkickHandler implements ClickHandler {

		public void onClick(ClickEvent event) {
			dialogBoxRegistration.show();
			dialogBoxRegistration.center();
			History.newItem("register");

		}
	}

	private class LoginEnterClickHandler implements ClickHandler {

		public void onClick(ClickEvent event) {
			FlowControl.go(ValeraGmailMain.valeraPanel);


		}

	}

	// private void showHomePage() {
	// showToken("register");
	// }
	//
	
	
	private static HomePageUiBinder uiBinder = GWT
			.create(HomePageUiBinder.class);

	interface HomePageUiBinder extends UiBinder<Widget, HomePage> {
	}

	
	
	

	public void setUpHistoryManagement() {
		// Make this class your history manager (see onValueChange method)
		History.addValueChangeHandler(this);
		// Handle any existing history token
		History.fireCurrentHistoryState();
		// Trap the user if they hit the back button too many times
		Window.addWindowClosingHandler(new ClosingHandler() {
			public void onWindowClosing(ClosingEvent event) {
				event.setMessage("Ran out of history.  Now leaving application, is that OK?");
			}
		});
	}

	private void showHomePage() {
		showToken("");
	}

	private void showToken(String token) {
		if (vPanel != null) {
			Label newItem = new Label(token);
			RootPanel.get().add(newItem);

		}
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		// Get the token from the event
		String token = null;
		if (event.getValue() != null)
			token = event.getValue().trim();
		// Check if the token is null or empty
		if ((token == null) || (token.equals("register")))
			showHomePage();
		// Else check what the token is and call the appropriate method.

		else
			// By default, show the Home page.
			showHomePage();
	}

}
