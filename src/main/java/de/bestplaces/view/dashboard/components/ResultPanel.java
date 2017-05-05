package de.bestplaces.view.dashboard.components;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Panel;
import de.bestplaces.model.Place;

import java.util.List;

/**
 * Created by franz on 25.11.2016.
 */
public class ResultPanel extends Panel {

    public ResultPanel(List<Place> placesList)
    {
        int numberOfPlaces = placesList.size();
        GridLayout layout = new GridLayout(3,(numberOfPlaces/3));

        for (Place place : placesList) {
            Tile tile = new Tile(place);
            tile.setSizeFull();
            layout.addComponent(tile);
        }

        layout.setMargin(true);
        layout.setSizeUndefined();

        setContent(layout);
    }

}
