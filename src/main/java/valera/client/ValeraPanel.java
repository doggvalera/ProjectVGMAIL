package valera.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import valera.client.gui.IntroPanel;
import valera.client.newmail.MessegaFrame;
import valera.client.sentMail.SentMail;

public class ValeraPanel extends Composite {

    @UiField Panel exampleArea;

    private MessegaFrame newMail;
    private SentMail sentMail;

    private static ValeraPanelUiBinder uiBinder = GWT.create(ValeraPanelUiBinder.class);
	    interface ValeraPanelUiBinder extends UiBinder<Widget, ValeraPanel> {}
	    
	    
	    public ValeraPanel (){
	        initWidget(uiBinder.createAndBindUi(this));

	        setWidgetToMaxWidthAndHeight();
	        Window.addResizeHandler(resizeHandler);
            IntroPanel introPanel = new IntroPanel();
	        setWidgetAsExample(introPanel);
	    }

	    
	    interface Resources extends ClientBundle {
	        @Source("email.jpg") public ImageResource logo();
	        
	    }
	    
	    private ResizeHandler resizeHandler = new ResizeHandler()
	    {
	        public void onResize (ResizeEvent event)
	        {
	            setWidgetToMaxWidthAndHeight();
	        }
	    };
	    
	    
	    @UiHandler("sentmail")
	    public void showCreate (ClickEvent event){
	    	History.newItem(HistoryT.SENTMAIL);
	    }

	  
	    public void showSentMail(){
	    	if (sentMail==null) sentMail = new SentMail();
	        setWidgetAsExample(sentMail);
	 
	    }

	    
	    
	    @UiHandler("newmail")
	    public void showComposite (ClickEvent event){
	    	History.newItem(HistoryT.NEWMAIL);
	    }

	 
	    public void showNewMail(){
	    	if (newMail==null) newMail = new MessegaFrame();
	        setWidgetAsExample(newMail);
	    }

	    
	    private void setWidgetToMaxWidthAndHeight ()
	    {
	        setWidth("100%");
	        setHeight(Window.getClientHeight() + "px");
	    }
	    
	    private void setWidgetAsExample (Widget widget)
	    {
	        exampleArea.clear();
	        exampleArea.add(widget);
	    }

}
