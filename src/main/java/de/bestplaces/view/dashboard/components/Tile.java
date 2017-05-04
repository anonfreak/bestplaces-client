package de.bestplaces.view.dashboard.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;
import de.bestplaces.model.Place;

/**
 * Created by franz on 25.11.2016.
 */
public class Tile extends Panel {

    public Tile(Place place)
    {
        VerticalLayout layout = new VerticalLayout();

        Label placeName = new Label(place.getName());
        placeName.setStyleName("huge");
        layout.addComponent(placeName);

        ImagePanel images = new ImagePanel(place.getPictures());
        layout.addComponent(images);

        Label address = new Label(place.getFormattedAddress());
        layout.addComponent(address);

        Label star;
        HorizontalLayout starLayout = new HorizontalLayout();
        for (int i = 0; i < place.getAverageStar() ; i++) {

            star = new Label(FontAwesome.STAR.getHtml() + "");
            star.setContentMode(ContentMode.HTML);
            starLayout.addComponent(star);
        }
        layout.addComponent(starLayout);

        String openNow = "Zur Zeit nicht geöffnet";
        if(place.isOpenNow())
        {
            openNow = "Zur Zeit geöffnet";
        }
        Label open = new Label(openNow);
        layout.addComponent(open);

        setContent(layout);


    }

}
