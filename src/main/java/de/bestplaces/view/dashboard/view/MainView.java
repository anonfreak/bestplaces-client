package de.bestplaces.view.dashboard.view;

/**
 * Created by franz on 28.11.2016.
 */
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import de.bestplaces.controller.NavigatorController;

/*
 * Dashboard MainView is a simple HorizontalLayout that wraps the menu on the
 * left and creates a simple container for the navigator on the right.
 */
@SuppressWarnings("serial")
public class MainView extends HorizontalLayout {

    public MainView(NavigatorController navigatorController) {
        setSizeFull();
        addStyleName("mainview");

        addComponent(new DashboardMenu(navigatorController));

        ComponentContainer content = new CssLayout();
        content.addStyleName("view-content");
        content.setSizeFull();
        addComponent(content);
        setExpandRatio(content, 1.0f);

        navigatorController.setContent(content);
    }
}
