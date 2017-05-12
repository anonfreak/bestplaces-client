package de.bestplaces.view.dashboard.components;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.model.FullPlace;

/**
 * Created by franz on 06.05.2017.
 */
public class PlaceView extends VerticalSplitPanel implements View {

    public static final String PLACE_VIEW = "PlaceView";
    private NavigatorController navigatorController;
    private FullPlace place;

    private Panel topPanel;
    private HorizontalSplitPanel bottomSplitPanel;
    private VerticalSplitPanel leftVerticalSplitPanel;
    private VerticalSplitPanel rightVerticalSplitPanel;

    public PlaceView(NavigatorController controller){
        navigatorController = controller;
    }

    public void setPlace(FullPlace place)
    {
        this.place = place;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        init();
    }

    private void init() {

        setSizeFull();
        addComponent(getTopPanel());
        addComponent(getBottomSplitPanel());
        setSplitPosition(5);
    }

    private Panel getTopPanel()
    {
        if(topPanel == null)
        {
            topPanel = new TopPanelPlace(place, navigatorController);
        }
        return topPanel;
    }

    private HorizontalSplitPanel getBottomSplitPanel()
    {
        if(bottomSplitPanel == null)
        {
            bottomSplitPanel = new HorizontalSplitPanel();
            bottomSplitPanel.setFirstComponent(getLeftVerticalSplitPanel());
            bottomSplitPanel.setSecondComponent(getRightVerticalSplitPanel());
            bottomSplitPanel.setSizeFull();
        }
        return bottomSplitPanel;
    }

    private VerticalSplitPanel getLeftVerticalSplitPanel() {

        if(leftVerticalSplitPanel == null)
        {
            leftVerticalSplitPanel = new VerticalSplitPanel();
            leftVerticalSplitPanel.addComponent(new AddressPanel(place));
            leftVerticalSplitPanel.addComponent(new OpeningHoursPanel(place));
            leftVerticalSplitPanel.setSizeFull();
        }
        return  leftVerticalSplitPanel;
    }

    private VerticalSplitPanel getRightVerticalSplitPanel() {

        if(rightVerticalSplitPanel == null)
        {
            rightVerticalSplitPanel = new VerticalSplitPanel();
            rightVerticalSplitPanel.addComponent(new ImagePanel(place.getPictures(), false));
            rightVerticalSplitPanel.addComponent(new RatingPanel(place));
            rightVerticalSplitPanel.setSizeFull();
        }
        return  rightVerticalSplitPanel;
    }


}
