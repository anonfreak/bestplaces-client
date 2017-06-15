package de.bestplaces.view.dashboard.components;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.PlaceController;
import de.bestplaces.controller.UserDataController;
import de.bestplaces.controller.VisitController;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Place;
import de.bestplaces.model.Visit;

import java.util.Date;
import java.util.List;

/**
 * Created by franz on 24.11.2016.
 */
public class Timeline extends VerticalLayout implements View{
    public static final String TIMELINE = "Timeline";
    private NavigatorController navigatorController;
    private TimelinePanel timelinePanel;
    private Label timeline;

    public Timeline(NavigatorController navigatorController){
        this.navigatorController = navigatorController;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        removeAllComponents();
        try {
            init();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void init() throws UnirestException {

        addComponent(getLabel());
        addComponent(getTimelinePanel());
    }


    public TimelinePanel getTimelinePanel() throws UnirestException {
        if(timelinePanel == null)
        {
            timelinePanel = new TimelinePanel(navigatorController);
            timelinePanel.setHeight("740px");
        }
        return timelinePanel;
    }

    private Label getLabel() {
        if(timeline == null)
        {
            timeline = new Label("Timeline");
            timeline.setStyleName("huge");
        }
        return timeline;
    }
}
