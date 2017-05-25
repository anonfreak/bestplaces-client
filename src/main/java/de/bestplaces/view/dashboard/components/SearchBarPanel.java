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

import javax.xml.soap.Text;
import java.util.List;

/**
 * Created by franz on 03.05.2017.
 */
public class SearchBarPanel extends Panel {

    private TextField search;
    private TextField location;

    public SearchBarPanel(NavigatorController navigatorController, SearchController searchController, Search searchView)
    {
        HorizontalLayout layoutSearchBar = new HorizontalLayout();
        layoutSearchBar.setSizeFull();
        layoutSearchBar.setMargin(false);


        Button backButton = new Button("Back", FontAwesome.ARROW_LEFT);
        backButton.setDescription("Go back to Timeline");
        backButton.addClickListener(clickEvent -> {
            navigatorController.switchToView(Pages.TIMELINE);
            searchView.removeResultPanel();
        });
        backButton.setSizeFull();
        layoutSearchBar.addComponent(backButton);


        search = new TextField();
        search.setInputPrompt("Search for a place..");
        search.addValidator(new StringLengthValidator("Must not be empty",0,100,false));
        search.setSizeFull();
        layoutSearchBar.addComponent(search);

        location = new TextField();
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
                searchView.addResultPanel(placesList, search.getValue(), location.getValue());
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

    public TextField getSearchField() {
        return search;
    }

    public TextField getLocationField() {
        return location;
    }
}
