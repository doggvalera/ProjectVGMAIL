package valera.client.newmail;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;


public class MessegaFrame extends Composite {

	
	
	private RichTextArea mail;
	private Button send;
	private Label error;
	private TextBox email;
	private TextBox themename;
	

	NewMail newMailSend;
	//NewMail questionRTL;

	/**
	 * Creates the Widget. Sets up history handling, the GUI components, and
	 * button handling.
	 */
	public MessegaFrame() {
		AbsolutePanel display = new AbsolutePanel();
		 
		final NewMail newMailSend = new NewMail("Question One ");
		//final Label answerLTR = new Label("LTR Answer is: ");
		//NewMail questionRTL = new NewMail("");
//		questionRTL.setDirection(Direction.RTL);
		display.add(newMailSend);
		//display.add(answerLTR);
		//display.add(questionRTL);
		

		initWidget(display);

		newMailSend.addMouseOverHandler(new MouseOverHandler() {
			public void onMouseOver(MouseOverEvent event) {
				newMailSend.getElement().getStyle()
						.setBorderStyle(BorderStyle.DOTTED);
				//questionLTR.getElement().getStyle().setBorderWidth(5, Unit.PX);
			}
		});
//
//		questionLTR.addValueChangeHandler(new ValueChangeHandler<String>() {
//			public void onValueChange(ValueChangeEvent<String> event) {
//				answerLTR.setText("LTR Answer is: " + event.getValue());
//			}
//		});

	
} 
	
}
