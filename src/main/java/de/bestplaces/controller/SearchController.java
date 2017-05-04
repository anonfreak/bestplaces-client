package de.bestplaces.controller;

import com.vaadin.navigator.View;
import de.bestplaces.model.Adress;
import de.bestplaces.model.Place;
import gherkin.lexer.Pl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franz on 03.05.2017.
 */
public class SearchController {

    public SearchController()
    {

    }

    public List<Place> search(String place, String town)
    {
        //Verbindung zu API
        //mit dem mitgegebenen Suchkriterien


        List<String> images = new ArrayList<>();
        images.add("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=CmRYAAAARKG0abvIum18OTmFfoQ1y9KO20PbZdd0xaH475d1O9dwE9dQy786Uu07rfjxs84Ke27LmrHCzaa-7CNbPxRKMx1Xq72oEKvQWudp948hZBC_tOnfP1_uecjnFvYgZJiLEhCeeGXuXxzfedqINysF8IpxGhQmwZCeDHXroICPs-Rb93haraVrfg&key=AIzaSyCk-JFceB-S7QIakQTajh1O7fMGkob7pO0");
        Place fakePlace = new Place("eindeutig", "Pizza", null, "Fritz-Erler-Straße 1, 76133 Karlsruhe, Germany",
                true, 4,images, null);

        List<String> images2 = new ArrayList<>();
        images2.add("https://s3-media2.fl.yelpcdn.com/bphoto/FK66TQEFCj4jtQSsP590vw/ls.jpg");

        Place fakePlace2 = new Place("eindeutig", "Eismarie", null, "Karlsstraße 15, 76137 Karlsruhe, Germany",
                true, 2,images2, null);

        List<Place> placesList = new ArrayList<>();
        placesList.add(fakePlace);
        placesList.add(fakePlace2);
        return placesList;
    }

}
