package de.bestplaces.view;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import de.bestplaces.model.Place;

/**
 * Created by franz on 25.11.2016.
 */
public class Tile extends Panel {

    public Tile()
    {
        GridLayout layout = new GridLayout(4,4);

        Label placeName = new Label("Pizzeria Mustermann");
        layout.addComponent(placeName,1, 1);

        Label spaceForImage = new Label("Image");
        layout.addComponent(spaceForImage,1,2);

        Label spaceForImageTwo = new Label("Image2");
        layout.addComponent(spaceForImageTwo,2,2);

        Label ort = new Label("Ort");
        layout.addComponent(ort,1,3);

        setContent(layout);


    }

}
