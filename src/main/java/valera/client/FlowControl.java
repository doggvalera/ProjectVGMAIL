package valera.client;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

public class FlowControl {
	
		private static FlowControl instance;
		private FlowControl() {}
		public static void go(Composite c) {
		    if (instance == null) instance = new FlowControl(); // not sure why we need this yet since everything is static.
		    RootPanel.get().clear();
		    RootPanel.get().getElement().getStyle().setPosition(Position.RELATIVE); // not sure why, but GWT throws an exception without this. Adding to CSS doesn't work.
		    // add, determine height/width, center, then move. height/width are unknown until added to document. Catch-22!
		    RootPanel.get().add(c);
		    int left = Window.getClientWidth() / 2 - c.getOffsetWidth() / 2; // find center
		    int top = Window.getClientHeight() / 2 - c.getOffsetHeight() / 2;
		    RootPanel.get().setWidgetPosition(c, left, top);
	
		}	
}
