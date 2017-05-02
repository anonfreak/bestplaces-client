package de.bestplaces.controller;

import com.vaadin.event.MouseEvents;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;
import de.bestplaces.model.Pages;
import de.bestplaces.view.dashboard.components.EditUserData;
import de.bestplaces.view.dashboard.components.Search;
import de.bestplaces.view.dashboard.components.Timeline;
import de.bestplaces.view.others.*;

/**
 * Created by kolbm on 01.05.2017.
 */
public class NavigatorController {
    private Navigator navigator;
    private UI ui;
    private UserDataController userDataController;

    public NavigatorController(UI ui){
        this.ui = ui;
        navigator = new Navigator(this.ui, this.ui);

        addViewsToNavigator();

        userDataController = new UserDataController();

        navigator.navigateTo("welcome");
    }

    public void switchToView(Pages page){
        navigator.navigateTo(page.toString());
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
        navigator = new Navigator(UI.getCurrent(), component);
        addViewsToNavigator();
    }

    public UserDataController getUserDataController(){
        return userDataController;
    }

    private void addViewsToNavigator(){
        // Create and register the views
        navigator.addView("welcome", new Welcome(this));
        navigator.addView(Pages.TIMELINE.toString(), new Timeline(this));
        navigator.addView(Pages.SEARCH.toString(), new Search(this));
        navigator.addView(Pages.EDITUSERDATA.toString(), new EditUserData(this));
    }
}
