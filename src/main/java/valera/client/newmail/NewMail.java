package valera.client.newmail;

import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class NewMail extends Composite 	/* implements HasText, HasDirection  */ {



		// The UI elements we will manipulate
	//	InlineLabel theQuestion;
		TextBox theAnswer;
		FlowPanel panel;
		RichTextArea mail;
		TextBox nameMail;
		TextBox theme;
		AbsolutePanel absolutePanel;
		VerticalPanel vPanel;
		protected Direction dir = Direction.DEFAULT;

		
		public NewMail(String question) {
			panel = new FlowPanel();
			theme = new TextBox();
			nameMail = new TextBox();
			mail = new RichTextArea();
			absolutePanel = new AbsolutePanel();
			buildDisplay();

			initWidget(absolutePanel);

			this.getElement().getStyle()
					.setProperty("border", "solid lightblue 2px");
		}

		private void buildDisplay() {
			panel.clear();
				panel.add(nameMail);
				panel.add(theme);
				panel.add(mail);
				absolutePanel.add(mail);
				absolutePanel.add(nameMail);}


		public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
			return addDomHandler(handler, MouseOverEvent.getType());
		}

	}