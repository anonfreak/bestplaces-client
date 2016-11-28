package de.bestplaces.view.dashboard.components;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import static de.bestplaces.MyUI.navigator;

/**
 * Created by franz on 24.11.2016.
 */
public class Timeline extends VerticalLayout implements View{
    public static final String TIMELINE = "Timeline";

    //TODO: das Dashboard ist die eigentliche View.. sobald das implementiert ist, wird das hier zum panel.., welches auf das dashboard gelegt wird.

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        init();
    }

    public void init()
    {
        HorizontalLayout layout = new HorizontalLayout();
        Notification.show("Welcome to your Timeline");
        Button button = new Button("Search");
        button.addClickListener(clickEvent -> navigator.navigateTo(Search.SEARCH));
        layout.addComponent(button);
        Button button1 = new Button("Edit User Data");
        button1.addClickListener(clickEvent -> navigator.navigateTo(EditUserData.EDITUSERDATA));
        layout.addComponent(button1);
        addComponent(layout);

        Tile placeOne = new Tile();
        addComponent(placeOne);

        Tile placeTwo = new Tile();
        addComponent(placeTwo);

        setMargin(true);

    }

}
