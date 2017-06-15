package de.bestplaces.view.dashboard.components;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.event.MouseEvents;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.PlaceController;
import de.bestplaces.controller.VisitController;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Visit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by franzi on 08.06.2017.
 */
public class TimelinePanel extends Panel {

    private NavigatorController navigatorController;
    private VisitController visitController;
    private PlaceController placeController;
    private VerticalLayout layout;

    public TimelinePanel(NavigatorController navigatorController) throws UnirestException {

        this.navigatorController = navigatorController;

        layout = new VerticalLayout();
        setContent(layout);
        visitController = navigatorController.getVisitController();
        placeController = navigatorController.getPlaceController();


        List<Visit> visitList = visitController.getVisits();

        for(Visit visit : visitList )
        {
            FullPlace fullPlace = placeController.getFullPlaceInformationToPlaceWithId(visit.getPlaceId(), visit.getUserString());
            String date = getDate(visit);
            addTimeLabel(date);
            addVisit(visit, fullPlace);
        }

        layout.setMargin(true);
        layout.setSizeUndefined();
    }

    public String getDate(Visit visit)
    {
        Date today = visit.getVisitTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, EEEEEEEEEEEE");
        String time = formatter.format(today);
        return time;
    }

    public void addVisit(Visit visit, FullPlace fullPlace)
    {
        VisitTile visitTile = new VisitTile(visit, fullPlace);
        visitTile.addClickListener(new MouseEvents.ClickListener() {
            @Override
            public void click(MouseEvents.ClickEvent clickEvent) {
                navigatorController.setVisit(visit, fullPlace);
                navigatorController.switchToView("VisitView");
            }
        });
        layout.addComponent(visitTile);
    }

    public void addTimeLabel(String visitDate)
    {
        Label date = new Label();
        date.setValue(visitDate);
        layout.addComponent(date);
    }
}
