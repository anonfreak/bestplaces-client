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
    private ResultPanel resultPanelMore;
    private Panel loadMoreButtonPanel;

    private String currentSearchValue;

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
    }

    private SearchBarPanel getSearchBarPanel() {
        if(searchBarPanel == null)
        {
            searchBarPanel = new SearchBarPanel(navigatorController, searchController, this);
        }
        return searchBarPanel;
    }

    public void addResultPanel(List<Place> placesList, String searchValue)
    {
        this.currentSearchValue = searchValue;
        if(placesList.size() == 20)
        {
            addLoadMoreButton();
        }
        if(resultPanel != null)
        {
            removeComponent(resultPanel);
        }
        resultPanel = new ResultPanel(placesList, navigatorController);
        resultPanel.setHeight("740px");

        addComponent(resultPanel);
    }

    public void addMoreResults(List<Place> placesList)
    {
        if(resultPanelMore != null)
        {
            removeComponent(resultPanelMore);
        }
        resultPanelMore = new ResultPanel(placesList, navigatorController);
        resultPanelMore.setHeight("740px");

        addComponent(resultPanelMore);

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
                        addResultPanel(placesList, currentSearchValue);
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
            removeComponent(loadMoreButtonPanel);
        }
        if(resultPanelMore !=null)
        {
            removeComponent(resultPanelMore);

        }
    }
}