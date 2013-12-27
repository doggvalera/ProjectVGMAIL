package valera.client.newmail;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;


public class MessegaFrame extends Composite {


    //NewMail newMailSend;


    /**
     * Creates the Widget. Sets up history handling, the GUI components, and
     * button handling.
     */


    public MessegaFrame() {
        AbsolutePanel display = new AbsolutePanel();

        final NewMail newMailSend = new NewMail("Question One ");

        display.add(newMailSend);


        initWidget(display);
    }

}
