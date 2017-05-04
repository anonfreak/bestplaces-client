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

        GridLayout layout = new GridLayout(3,4);


        for (Place place : placesList) {
            Tile tile = new Tile(place);
            layout.addComponent(tile);
        }





        layout.setMargin(true);
        setContent(layout);
    }

}
