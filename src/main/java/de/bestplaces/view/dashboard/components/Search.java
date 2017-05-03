package de.bestplaces.view.dashboard.components;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.SearchController;
import de.bestplaces.model.Pages;
import de.bestplaces.model.Place;

import java.util.List;

/**
 * Created by franz on 25.11.2016.
 */
public class Search extends VerticalLayout implements View {
    public static final String SEARCH = "Search";
    private NavigatorController navigatorController;
    private SearchController searchController;

    public Search(NavigatorController controller){
        navigatorController = controller;
        searchController = new SearchController();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        init();
    }


    public void init()
    {
        SearchBarPanel searchBarPanel = new SearchBarPanel(navigatorController, searchController, this);
        addComponent(searchBarPanel);
    }

    public void addResultPanel(List<Place> placesList)
    {
        ResultPanel tileViewPanel = new ResultPanel(placesList);
        addComponent(tileViewPanel);
    }
}
