package de.bestplaces.view.others;

import com.vaadin.ui.Window;
import de.bestplaces.controller.NavigatorController;


/**
 * Created by kolbm on 01.05.2017.
 */
public abstract class CustomizedWindow extends Window {
    protected NavigatorController navigatorController;

    public CustomizedWindow(String name) {
        super(name);
    }

    public NavigatorController getNavigatorController() {
        return navigatorController;
    }

    public void setNavigatorController(NavigatorController navigatorController) {
        this.navigatorController = navigatorController;
    }
}
