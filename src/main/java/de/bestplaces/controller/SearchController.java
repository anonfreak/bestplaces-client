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

        Adress adress = new Adress("karlstraße", 167, "Karlsruhe", 0);
        Place fakePlace = new Place(1, "Pizza", null, adress, "0721826110", null, null,true,"good", 5,null);

        List<Place> placesList = new ArrayList<>();
        placesList.add(fakePlace);
        return placesList;
    }

}
