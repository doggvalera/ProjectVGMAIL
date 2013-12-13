package valera.client.sentMail;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;


public class SentMail extends Composite{
	//private Label vasa;
	ReportSizeLabel theLabel;
	public SentMail() {
		
	
			theLabel = new ReportSizeLabel("What's my size?");
			initWidget(theLabel);
			
			// Add a ClickHandler to the label - this should cause an exception to be raised
			// since ReportSizeLabel overides the addClickHandler method of InnerLabel to explicitly
			// prevent a ClickHandler being added
			theLabel.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					Window.alert("You clicked me!");
				}			
			});
	
	}
}
