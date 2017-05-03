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

        GridLayout layout = new GridLayout(5,5);

        for (Place place : placesList) {
            Tile tile = new Tile(place);
            layout.addComponent(tile);
        }


          //  for (int i = 0; i < 5 ; i++) {
           //     for (int j = 0; j < 5; j++) {


        layout.setMargin(true);
        setContent(layout);
    }

}
