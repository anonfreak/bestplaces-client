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

    private Label timeline;
    private Tile placeOne;
    private Tile placeTwo;

    public Timeline(NavigatorController controller){
        this.navigatorController = controller;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        init();
    }

    public void init()
    {
        addComponent(getLabel());

        //fake places
        addComponent(getPlace());
        addComponent(getPlaceTwo());

        setMargin(true);
    }

    private Label getLabel() {
        if(timeline == null)
        {
            timeline = new Label("Timeline");
            timeline.setStyleName("huge");
        }
        return timeline;
    }

    private Tile getPlace()
    {
        Adress adress = new Adress("karlstraße", 167, "Karlsruhe", 0);
        Place place = new Place(1, "Pizza", null, adress, "0721826110", null, null,true,"good", 5,null);

        if(placeOne == null)
        {
            placeOne = new Tile(place);
        }

        return placeOne;
    }

    private Tile getPlaceTwo()
    {
        Adress adress = new Adress("karlstraße", 167, "Karlsruhe", 0);
        Place place = new Place(1, "Pizza", null, adress, "0721826110", null, null,true,"good", 5,null);

        if(placeTwo == null)
        {
            placeTwo = new Tile(place);
        }

        return placeTwo;
    }


}
