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
        Place place = new Place("eindeutig", "Pizza", null, "Fritz-Erler-Straße 1, 76133 Karlsruhe, Germany",
                true, 4,null, null);

        if(placeOne == null)
        {
            placeOne = new Tile(place);
        }

        return placeOne;
    }

    private Tile getPlaceTwo()
    {
        Place place2 = new Place("eindeutig", "Eismarie", null, "Karlsstraße 15, 76137 Karlsruhe, Germany",
                true, 4,null, null);

        if(placeTwo == null)
        {
            placeTwo = new Tile(place2);
        }

        return placeTwo;
    }


}
