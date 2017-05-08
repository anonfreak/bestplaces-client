package de.bestplaces.view.dashboard.components;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.event.MouseEvents;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.PlaceController;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Pages;
import de.bestplaces.model.Place;

import java.util.List;

/**
 * Created by franz on 25.11.2016.
 */
public class ResultPanel extends Panel {

    private NavigatorController navigatorController;

    public ResultPanel(List<Place> placesList, NavigatorController navigatorController)
    {
        this.navigatorController = navigatorController;
        int numberOfPlaces = placesList.size();
        int rows = (numberOfPlaces/3);
        if(rows < 1)
        {
            rows = 1;
        }

        GridLayout layout = new GridLayout(3,rows);

        for (Place place : placesList) {
            Tile tile = new Tile(place);
            tile.setSizeFull();
            tile.addClickListener(new MouseEvents.ClickListener() {
                @Override
                public void click(MouseEvents.ClickEvent clickEvent) {

                    // hier über Controller zur nächsten View kommen
                    // aber nicht über den Navigator, weil der eine neue page erzeugt
                    // am besten über place controller
                    PlaceController placeController = navigatorController.getPlaceController();
                    FullPlace fullPlace= null;
                    try {
                        fullPlace = placeController.getFullPlaceInformationToPlaceWithId(place.getPlaceID(), null);
                    } catch (UnirestException e) {
                        e.printStackTrace();
                    }
                    // dem navigator irgendwie den fullplace mitgeben
                    navigatorController.setPlace(fullPlace);
                    navigatorController.switchToView("PlaceView");
                }
            });
            layout.addComponent(tile);
        }

        layout.setMargin(true);
        layout.setSizeUndefined();

        setContent(layout);
    }

}
