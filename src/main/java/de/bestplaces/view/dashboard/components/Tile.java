package de.bestplaces.view.dashboard.components;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import de.bestplaces.model.Place;

/**
 * Created by franz on 25.11.2016.
 */
public class Tile extends Panel {

    public Tile(Place place)
    {
        GridLayout layout = new GridLayout(4,4);

        Label placeName = new Label(place.getName());
        layout.addComponent(placeName,1, 1);

        Label spaceForImage = new Label("Image2");
        layout.addComponent(spaceForImage,1,2);

        Label spaceForImageTwo = new Label("Image2");
        layout.addComponent(spaceForImageTwo,2,2);

        Label ort = new Label(place.getAdress().getTown());
        layout.addComponent(ort,1,3);

        setContent(layout);


    }

}
