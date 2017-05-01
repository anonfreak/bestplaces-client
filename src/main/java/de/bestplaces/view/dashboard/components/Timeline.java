package de.bestplaces.view.dashboard.components;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import de.bestplaces.controller.NavigatorController;

/**
 * Created by franz on 24.11.2016.
 */
public class Timeline extends VerticalLayout implements View{
    public static final String TIMELINE = "Timeline";
    private NavigatorController navigatorController;

    public Timeline(NavigatorController controller){
        this.navigatorController = controller;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        init();
    }

    public void init()
    {
        HorizontalLayout layout = new HorizontalLayout();
        Notification.show("Welcome to your Timeline");
        Label timeline = new Label("Timeline");
        timeline.setStyleName("huge");
        layout.addComponent(timeline);
        addComponent(layout);

        Tile placeOne = new Tile();
        addComponent(placeOne);

        Tile placeTwo = new Tile();
        addComponent(placeTwo);

        setMargin(true);

    }

}
