package valera.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;
import valera.client.gui.home.HomePage;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ValeraGmailMain implements EntryPoint, ValueChangeHandler<String> {

    public static MainPanel mainPanel;
    HomePage homePage = new HomePage();


    public void onModuleLoad() {
        mainPanel = new MainPanel();
        RootPanel.get().add(homePage, 0, 0);
        setUpHistoryManagement();
    }

    public void setUpHistoryManagement() {
        // Make this class your history manager (see onValueChange method)
        History.addValueChangeHandler(this);
        // Handle any existing history token
        History.fireCurrentHistoryState();
    }

    public void onValueChange(ValueChangeEvent<String> event) {
        // TODO Auto-generated method stub
        String page = event.getValue().trim();
        // Check if the token is null or empty
        if ((page == null) || (page.equals(""))) {
        }
        //showHomePage();
        // Else check what the token is and call the appropriate method.
        else if (page.equals(HistoryT.SENTMAIL))
            mainPanel.showSentMail();
        else if (page.equals(HistoryT.NEWMAIL))
            mainPanel.showNewMail();
        else if (page.equals(HistoryT.INBOX))
            mainPanel.showInbox();
    }
}
