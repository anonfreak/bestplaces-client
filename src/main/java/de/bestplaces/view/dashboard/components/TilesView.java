package de.bestplaces.view.dashboard.components;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Panel;

/**
 * Created by franz on 25.11.2016.
 */
public class TilesView extends Panel {

    public TilesView()
    {
            GridLayout layout = new GridLayout(5,5);

            for (int i = 0; i < 5 ; i++) {
                for (int j = 0; j < 5; j++) {

                layout.addComponent(new Tile(),j,i);
                }
            }
        layout.setMargin(true);
        setContent(layout);
    }

}
