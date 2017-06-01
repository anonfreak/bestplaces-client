package de.bestplaces.view.dashboard.components;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.model.FullPlace;

/**
 * Created by franzi
 * on 06.05.2017.
 */
public class PlaceView extends VerticalSplitPanel implements View {

    private NavigatorController navigatorController;
    private FullPlace place;

    private Panel topPanel;
    private HorizontalSplitPanel contentPanel;
    private VerticalSplitPanel leftVerticalSplitPanel;
    private VerticalSplitPanel rightVerticalSplitPanel;

    private AddressPanel addressPanel;
    private OpeningHoursPanel openingHoursPanel;
    private ImagePanel imagePanel;
    private RatingPanel ratingPanel;

    public PlaceView(NavigatorController controller) {
        navigatorController = controller;
    }

    public void setPlace(FullPlace place) {
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
            topPanel = new TopPanelPlace(place, navigatorController);
        }
        return topPanel;
    }

    private HorizontalSplitPanel getContentPanel() {
        if (contentPanel == null) {
            contentPanel = new HorizontalSplitPanel();
            contentPanel.setFirstComponent(getLeftVerticalSplitPanel());
            contentPanel.setSecondComponent(getRightVerticalSplitPanel());
            contentPanel.setSizeFull();
        }
        return contentPanel;
    }

    private VerticalSplitPanel getLeftVerticalSplitPanel() {

        if (leftVerticalSplitPanel == null) {
            leftVerticalSplitPanel = new VerticalSplitPanel();
            leftVerticalSplitPanel.addComponent(getAddressPanel());
            leftVerticalSplitPanel.addComponent(getOpeningHoursPanel());
            leftVerticalSplitPanel.setSizeFull();
        }
        return leftVerticalSplitPanel;
    }

    private VerticalSplitPanel getRightVerticalSplitPanel() {

        if (rightVerticalSplitPanel == null) {
            rightVerticalSplitPanel = new VerticalSplitPanel();
            rightVerticalSplitPanel.addComponent(getImagePanel());
            rightVerticalSplitPanel.addComponent(getRatingPanel());
            rightVerticalSplitPanel.setSizeFull();
        }
        return rightVerticalSplitPanel;
    }

    private AddressPanel getAddressPanel() {
        if(addressPanel == null)
        {
         //   Page.Styles styles = Page.getCurrent().getStyles();
//        styles.add(".v-app .my-panel .v-panel-caption { background-color:#00bfff; }");
         //   styles.add("$color1: #00bfff;");
        //    styles.add(".v-panel-caption-color1 {\n" +
       //             "    @include valo-panel-caption-style($background-color: $color1);\n" +
         //           "  }");
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
}
