package de.bestplaces.view.dashboard.components;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.model.Adress;
import de.bestplaces.model.Place;

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

        Adress adress = new Adress("karlstraße", 167, "Karlsruhe", 0);
        Place place = new Place(1, "Pizza", null, adress, "0721826110", null, null,true,"good", 5,null);


        Tile placeOne = new Tile(place);
        addComponent(placeOne);

        Tile placeTwo = new Tile(place);
        addComponent(placeTwo);

        setMargin(true);

    }

}
