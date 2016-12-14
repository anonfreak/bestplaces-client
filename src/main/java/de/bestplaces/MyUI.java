package de.bestplaces;

import javax.servlet.annotation.WebServlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import de.bestplaces.view.dashboard.components.EditUserData;
import de.bestplaces.view.dashboard.components.Search;
import de.bestplaces.view.dashboard.components.Timeline;
import de.bestplaces.view.others.Welcome;

import java.io.IOException;

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
        initJackson();
        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views
        navigator.addView(Welcome.WELCOME, Welcome.class);
        navigator.addView(Timeline.TIMELINE, Timeline.class);
        navigator.addView(Search.SEARCH, Search.class);
        navigator.addView(EditUserData.EDITUSERDATA, EditUserData.class);

        navigator.navigateTo(Welcome.WELCOME);
    }

    private void initJackson(){
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
