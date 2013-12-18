package valera.client.inbox;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import valera.shared.ValeraServiceAsync;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by valerijszemlanikins on 18.12.13.
 */


public class InboxPanel extends Composite{



    private ValeraServiceAsync service;
    private static InboxUiBinder uiBinder = GWT
            .create(InboxUiBinder.class);
    interface InboxUiBinder extends UiBinder<Widget, InboxPanel> {
    }





    @UiField
    Button refresh;
    @UiField
    VerticalPanel vPanel;

    Table table = new Table();
    public InboxPanel(String question) {


        initWidget(uiBinder.createAndBindUi(this));
        this.getElement().getStyle()
                .setProperty("border", "solid lightblue 2px");
                vPanel.add(table);



    }

    public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
        return addDomHandler(handler, MouseOverEvent.getType());
    }
}
