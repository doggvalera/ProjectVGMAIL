package valera.client.inbox;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import valera.client.newmail.NewMail;

/**
 * Created by valerijszemlanikins on 18.12.13.
 */


public class InboxFrame extends Composite {


    public InboxFrame() {

        AbsolutePanel display = new AbsolutePanel();

        final InboxPanel inboxPanel = new InboxPanel("Question One");
     //   final Tester tester = new Tester();
       display.add(inboxPanel);
        //display.add(tester);


        initWidget(display);

        inboxPanel.addMouseOverHandler(new MouseOverHandler() {
            public void onMouseOver(MouseOverEvent event) {
                inboxPanel.getElement().getStyle()
                        .setBorderStyle(Style.BorderStyle.DOTTED);


            }
        });

    }
}
