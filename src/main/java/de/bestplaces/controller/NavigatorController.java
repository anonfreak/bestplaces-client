package de.bestplaces.controller;

import com.vaadin.event.MouseEvents;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Pages;
import de.bestplaces.model.Visit;
import de.bestplaces.view.dashboard.components.*;
import de.bestplaces.view.others.*;


/**
 * Created by kolbm on 01.05.2017.
 */
public class NavigatorController {
    private Navigator navigator;
    private UI ui;
    private UserDataController userDataController;
    private PlaceController placeController;
    private SearchController searchController;
    private VisitController visitController;

    private PlaceView placeView;
    private Search searchView;
    private VisitView visitView;


    public NavigatorController(UI ui){
        this.ui = ui;
        navigator = new Navigator(this.ui, this.ui);

        addViewsToNavigator();

        userDataController = new UserDataController();
        placeController = new PlaceController();
        searchController = new SearchController();
        visitController = new VisitController();

        navigator.navigateTo("welcome");
    }

    public void switchToView(Pages page){
        navigator.navigateTo(page.toString());
    }

    public void switchToView(String view)
    {
        navigator.navigateTo(view);

    }

    public void openWindow(CustomizedWindow window){
        window.setNavigatorController(this);
        ui.addClickListener(new MouseEvents.ClickListener() {

            @Override
            public void click(MouseEvents.ClickEvent event) {
                window.close();
            }
        });
        ui.addWindow(window);
    }

    public void setContent(ComponentContainer component){
        navigator.destroy();
        navigator = new Navigator(ui, component);
        addViewsToNavigator();
    }

    public UserDataController getUserDataController(){
        return userDataController;
    }

    public PlaceController getPlaceController() {
        return placeController;
    }

    public SearchController getSearchController() {
        return searchController;
    }

    public VisitController getVisitController() {
        return visitController;
    }

    private void addViewsToNavigator(){
        // Create and register the views
        navigator.addView("welcome", new Welcome(this));
        navigator.addView(Pages.TIMELINE.toString(), new Timeline(this));
        searchView = new Search(this);
        navigator.addView(Pages.SEARCH.toString(), searchView);
        navigator.addView(Pages.EDITUSERDATA.toString(), new EditUserData(this));

        navigator.addView("PlaceView", getPlaceView());
        navigator.addView("VisitView", getVisitView());
    }

    public void setPlace(FullPlace place)
    {
        navigator.addView("PlaceView", getPlaceView());
        placeView.setPlace(place);
    }

    public Search getSearch()
    {
        return searchView;
    }

    public PlaceView getPlaceView()
    {
        if(placeView == null)
        {
            placeView = new PlaceView(this);
        }
        return placeView;
    }

    public void setPlaceViewBack(){
        placeView = null;
    }

    public void setVisitViewBack()
    {
        visitView = null;
    }

    public void setVisit(Visit visit, FullPlace place)
    {
        navigator.addView("VisitView", getVisitView());
        visitView.setVisit(visit, place);
    }

    public VisitView getVisitView()
    {
        if (visitView == null)
        {
            visitView = new VisitView(this);
        }
        return visitView;
    }
}
