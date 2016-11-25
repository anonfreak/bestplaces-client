package de.bestplaces;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import de.bestplaces.view.EditUserData;
import de.bestplaces.view.Search;
import de.bestplaces.view.Timeline;
import de.bestplaces.view.Welcome;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    public static Navigator navigator;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("BestPlaces");

        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views
        navigator.addView(Welcome.WELCOME, Welcome.class);
        //TODO: Anstelle der Timeline wird hier das Dashboard eingefügt
        navigator.addView(Timeline.TIMELINE, Timeline.class);
        navigator.addView(Search.SEARCH, Search.class);
        navigator.addView(EditUserData.EDITUSERDATA, EditUserData.class);

        navigator.navigateTo(Welcome.WELCOME);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
