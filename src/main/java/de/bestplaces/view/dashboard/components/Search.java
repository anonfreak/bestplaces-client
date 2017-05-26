package de.bestplaces.view.dashboard.components;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.SearchController;
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
    private Panel loadMoreButtonPanel;

    private String currentSearchValue;
    private String currentLocationValue;
    private List<Place> currentPlaceList;

    public Search(NavigatorController controller){
        navigatorController = controller;
        searchController = navigatorController.getSearchController();

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        init();
    }


    public void init()
    {
        addComponent(getSearchBarPanel());
        removeResultPanel();

        if(getSearchBarPanel().getSearchField().getValue().equals(currentSearchValue)
                && getSearchBarPanel().getLocationField().getValue().equals(currentLocationValue))
        {
            addResultPanel(currentPlaceList, currentSearchValue, currentLocationValue);
        }

    }

    private SearchBarPanel getSearchBarPanel() {
        if(searchBarPanel == null)
        {
            searchBarPanel = new SearchBarPanel(navigatorController, searchController, this);
        }
        return searchBarPanel;
    }

    public void addResultPanel(List<Place> placesList, String searchValue, String locationValue)
    {
        this.currentLocationValue = locationValue;
        this.currentSearchValue = searchValue;
        this.currentPlaceList = placesList;
        if(currentPlaceList.size() == 20)
        {
            addLoadMoreButton();
        }
        if(resultPanel != null)
        {
            removeComponent(resultPanel);
        }
        resultPanel = new ResultPanel(currentPlaceList, navigatorController);
        resultPanel.setHeight("740px");

        addComponent(resultPanel);
    }

    public void addLoadMoreButton()
    {
        if(loadMoreButtonPanel == null)
        {
            loadMoreButtonPanel = new Panel();
            VerticalLayout layout = new VerticalLayout();

            Button loadMore = new Button("Load more");
            loadMore.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    SearchController searchController = navigatorController.getSearchController();
                    try {
                        List<Place> placesList = searchController.searchMore(currentSearchValue);
                        addResultPanel(placesList, currentSearchValue, currentLocationValue);
                    } catch (UnirestException e) {
                        e.printStackTrace();
                    }
                }
            });

            layout.addComponent(loadMore);
            loadMoreButtonPanel.setContent(layout);

            addComponent(loadMoreButtonPanel);
        }
    }

    public void removeResultPanel()
    {
        if(resultPanel != null)
        {
            removeComponent(resultPanel);
        }
        if(loadMoreButtonPanel !=null)
        {
            removeComponent(loadMoreButtonPanel);

        }
    }
}