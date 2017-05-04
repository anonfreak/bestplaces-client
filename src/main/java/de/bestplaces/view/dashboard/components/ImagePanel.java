package de.bestplaces.view.dashboard.components;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;

import java.util.List;

/**
 * Created by franz on 04.05.2017.
 */
public class ImagePanel extends Panel {

    public ImagePanel(List<String> pictures)
    {
        HorizontalLayout layout = new HorizontalLayout();
        for (String picture : pictures) {
            Image image = new Image();
            image.setSource(new ExternalResource(picture));
            layout.addComponent(image);
        }
        setContent(layout);
    }

}
