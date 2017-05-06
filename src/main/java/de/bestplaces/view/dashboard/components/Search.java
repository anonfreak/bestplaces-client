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
    private SearchBarPanel searchBarPanel;
    private ResultPanel resultPanel;

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
        addComponent(getSearchBarPanel());
        removeResultPanel();
    }

    private SearchBarPanel getSearchBarPanel() {
        if(searchBarPanel == null)
        {
            searchBarPanel = new SearchBarPanel(navigatorController, searchController, this);
        }
        return searchBarPanel;
    }

    public void addResultPanel(List<Place> placesList)
    {
        if(resultPanel != null)
        {
            removeComponent(resultPanel);
        }
        resultPanel = new ResultPanel(placesList, navigatorController);
        resultPanel.setHeight("1000px");

        addComponent(resultPanel);
    }
    public void removeResultPanel()
    {
        if(resultPanel != null)
        {
            removeComponent(resultPanel);
        }
    }


}
