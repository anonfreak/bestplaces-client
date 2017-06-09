package de.bestplaces.view.dashboard.components;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Visit;

/**
 * Created by franzi on 09.06.2017.
 */
public class VisitView extends VerticalSplitPanel implements View {

    private NavigatorController navigatorController;
    private Visit visit;
    private FullPlace place;

    private TopPanelVisit topPanel;
    private Panel contentPanel;

    private HorizontalSplitPanel placePanelOne;
    private HorizontalSplitPanel placePanelTwo;

    private HorizontalSplitPanel visitPanel;

    private AddressPanel addressPanel;
    private OpeningHoursPanel openingHoursPanel;
    private ImagePanel imagePanel;
    private RatingPanel ratingPanel;

    private VisitInformationPanel visitInformationPanel;
    private VisitNotesPanel visitNotesPanel;

    public VisitView(NavigatorController controller) {
        navigatorController = controller;
    }

    public void setVisit(Visit visit, FullPlace place) {
        this.visit = visit;
        this.place = place;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        init();
    }

    private void init() {

        setSizeFull();
        addComponent(getTopPanel());
        addComponent(getContentPanel());
        setSplitPosition(5);
    }

    private Panel getTopPanel() {
        if (topPanel == null) {
            topPanel = new TopPanelVisit(place, navigatorController);
        }
        return topPanel;
    }

    private Panel getContentPanel()
    {
        if(contentPanel == null)
        {
            contentPanel = new Panel();
            VerticalLayout layout = new VerticalLayout();
            layout.addComponent(getPlacePanelOne());
            layout.addComponent(getPlacePanelTwo());
            layout.addComponent(getVisitPanel());
            layout.setHeightUndefined();
            contentPanel.setHeight("740px");
            contentPanel.setContent(layout);
        }
        return contentPanel;
    }

    private HorizontalSplitPanel getPlacePanelOne() {
        if (placePanelOne == null) {
            placePanelOne = new HorizontalSplitPanel();
            placePanelOne.setFirstComponent(getAddressPanel());
            placePanelOne.setSecondComponent(getImagePanel());
            placePanelOne.setHeight("375px");
        }
        return placePanelOne;
    }

    private HorizontalSplitPanel getPlacePanelTwo() {

        if (placePanelTwo == null) {
            placePanelTwo = new HorizontalSplitPanel();
            placePanelTwo.setFirstComponent(getOpeningHoursPanel());
            placePanelTwo.setSecondComponent(getRatingPanel());
            placePanelTwo.setSizeFull();
        }
        return placePanelTwo;
    }


    private AddressPanel getAddressPanel() {
        if(addressPanel == null)
        {
            addressPanel = new AddressPanel(place);
            addressPanel.addStyleName("v-app .my-panel .v-panel-caption");
        }
        return addressPanel;
    }

    private OpeningHoursPanel getOpeningHoursPanel() {
        if(openingHoursPanel == null)
        {
            openingHoursPanel = new OpeningHoursPanel(place);
            openingHoursPanel.addStyleName(".v.app .v-panel .v-panel-caption");
        }
        return openingHoursPanel;
    }

    private ImagePanel getImagePanel() {
        if(imagePanel == null)
        {
            imagePanel = new ImagePanel(place.getPictures(), false);
        }
        return imagePanel;
    }

    private RatingPanel getRatingPanel() {
        if (ratingPanel==null)
        {
            ratingPanel = new RatingPanel(place);
        }
        return ratingPanel;
    }

    private HorizontalSplitPanel getVisitPanel()
    {
        if (visitPanel == null)
        {
            visitPanel = new HorizontalSplitPanel();
            visitPanel.setFirstComponent(getVisitInformationPanel());
            visitPanel.setSecondComponent(getVisitNotesPanel());
            visitPanel.setSizeFull();
        }
        return visitPanel;
    }

    public VisitInformationPanel getVisitInformationPanel() {
        if(visitInformationPanel == null)
        {
            visitInformationPanel = new VisitInformationPanel(visit);
        }
        return visitInformationPanel;
    }

    public VisitNotesPanel getVisitNotesPanel() {
        if(visitNotesPanel == null)
        {
            visitNotesPanel = new VisitNotesPanel(visit);
        }
        return visitNotesPanel;
    }
}
