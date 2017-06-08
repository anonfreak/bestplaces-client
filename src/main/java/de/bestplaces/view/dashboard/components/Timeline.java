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
    private VisitController visitController;
    private PlaceController placeController;

    private Label timeline;

    public Timeline(NavigatorController navigatorController){
        this.navigatorController = navigatorController;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        try {
            init();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void init() throws UnirestException {
        visitController = navigatorController.getVisitController();
        placeController = navigatorController.getPlaceController();

        addComponent(getLabel());

        List<Visit> visitList = visitController.getVisits(navigatorController.getUserDataController().getUsername());

        // hier muss abgefragt werden, ob es das Datum schon gab, dann wird kein neues Label hinzugefügt
        // villt Logik einbauen, dass Heute, Gestern, Vorgestern und dann Datum angezeigt wird
        for(Visit visit : visitList )
        {
            FullPlace fullPlace = placeController.getFullPlaceInformationToPlaceWithId(visit.getPlaceId(),
                    visit.getUserString());
            Date date = visit.getVisitTime();
            addTimeLabel(date);
            addVisit(visit, fullPlace);
        }

        setMargin(true);
    }

    public void addVisit(Visit visit, FullPlace fullPlace)
    {
        addComponent(new VisitTile(visit, fullPlace));
    }

    public void addTimeLabel(Date visitDate)
    {
        Label date = new Label();
        date.setValue(visitDate.toString());
        addComponent(date);
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
