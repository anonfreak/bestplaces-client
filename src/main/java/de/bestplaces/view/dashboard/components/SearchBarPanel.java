package de.bestplaces.view.dashboard.components;

import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

import com.vaadin.ui.Panel;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.SearchController;
import de.bestplaces.model.Pages;
import de.bestplaces.model.Place;

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
                List<Place> placesList = searchController.search(search.getValue(), location.getValue());
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