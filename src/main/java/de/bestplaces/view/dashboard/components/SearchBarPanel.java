package de.bestplaces.view.dashboard.components;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

import com.vaadin.ui.Panel;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.SearchController;
import de.bestplaces.model.Pages;
import de.bestplaces.model.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franz on 03.05.2017.
 */
public class SearchBarPanel extends Panel {

    public SearchBarPanel(NavigatorController navigatorController, SearchController searchController, Search searchView)
    {
        HorizontalLayout layoutSearchBar = new HorizontalLayout();
        layoutSearchBar.setSizeFull();
        layoutSearchBar.setMargin(false);


        Button backButton = new Button("Back", FontAwesome.ARROW_LEFT);
        backButton.addClickListener(clickEvent -> {
            navigatorController.switchToView(Pages.TIMELINE);
            searchView.removeResultPanel();
        });
        backButton.setSizeFull();
        layoutSearchBar.addComponent(backButton);


        TextField search = new TextField();
        search.setInputPrompt("Search for a place..");
        search.addValidator(new StringLengthValidator("Must not be empty",0,100,false));
        search.setSizeFull();
        layoutSearchBar.addComponent(search);

        TextField location = new TextField();
        location.setInputPrompt("In which town do you want to search?");
        location.addValidator(new StringLengthValidator("Must not be empty",0,100,false));
        location.setSizeFull();
        layoutSearchBar.addComponent(location);

        Button searchButton = new Button("Search", FontAwesome.SEARCH);
        searchButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                List<Place> placesList = null;
                try {
                    placesList = searchController.search(search.getValue(), location.getValue());
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
                List<String> images = new ArrayList<>();
                placesList = new ArrayList<>();
                images.add("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=CmRYAAAARKG0abvIum18OTmFfoQ1y9KO20PbZdd0xaH475d1O9dwE9dQy786Uu07rfjxs84Ke27LmrHCzaa-7CNbPxRKMx1Xq72oEKvQWudp948hZBC_tOnfP1_uecjnFvYgZJiLEhCeeGXuXxzfedqINysF8IpxGhQmwZCeDHXroICPs-Rb93haraVrfg&key=AIzaSyCk-JFceB-S7QIakQTajh1O7fMGkob7pO0");
                images.add("https://www.karlsruhe-insider.de/wp-content/uploads/2015/09/Eismarie1.jpg");
                Place fakePlace = new Place("eindeutig", "Pizza", null, "Fritz-Erler-Straße 1, 76133 Karlsruhe, Germany",
                        true, 4,images, null);
                placesList.add(fakePlace);
                searchView.addResultPanel(placesList);
                location.setValue("");
                search.setValue("");
            }
        });
        searchButton.setSizeFull();
        layoutSearchBar.addComponent(searchButton);

        layoutSearchBar.setExpandRatio(backButton, 0.1f);
        layoutSearchBar.setExpandRatio(search, 0.4f);
        layoutSearchBar.setExpandRatio(location, 0.4f);
        layoutSearchBar.setExpandRatio(searchButton, 0.1f);

        setContent(layoutSearchBar);

    }
}
