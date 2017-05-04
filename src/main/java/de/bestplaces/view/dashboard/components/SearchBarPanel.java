package de.bestplaces.view.dashboard.components;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import com.vaadin.ui.Panel;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.SearchController;
import de.bestplaces.model.Pages;
import de.bestplaces.model.Place;
import gherkin.lexer.Pl;

import java.util.List;

/**
 * Created by franz on 03.05.2017.
 */
public class SearchBarPanel extends Panel {

    public SearchBarPanel(NavigatorController navigatorController, SearchController searchController, Search searchView)
    {
        HorizontalLayout layoutSearchBar = new HorizontalLayout();
        //layoutSearchBar.setWidth("100%");
        layoutSearchBar.setSizeFull();
        layoutSearchBar.setMargin(false);

        //CssLayout group = new CssLayout();
        //group.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        //layoutSearchBar.addComponent(group);

        Button backButton = new Button("Back", FontAwesome.ARROW_LEFT);
        backButton.addClickListener(clickEvent -> navigatorController.switchToView(Pages.TIMELINE));
        backButton.setSizeFull();
        layoutSearchBar.addComponent(backButton);


        TextField search = new TextField();
        search.setInputPrompt("Search for a place..");
        search.setSizeFull();
        layoutSearchBar.addComponent(search);

        TextField location = new TextField();
        location.setInputPrompt("In which town do you want to search?");
        location.setSizeFull();
        layoutSearchBar.addComponent(location);

        Button searchButton = new Button("Search", FontAwesome.SEARCH);
        searchButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                List<Place> placesList = searchController.search(search.getValue(), location.getValue());
                searchView.addResultPanel(placesList);
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
