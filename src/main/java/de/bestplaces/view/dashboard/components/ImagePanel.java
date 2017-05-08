package de.bestplaces.view.dashboard.components;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

import java.util.List;

/**
 * Created by franz on 04.05.2017.
 */
public class ImagePanel extends Panel {

    public ImagePanel(List<String> pictures, boolean showOnlyOnePicture) {
        HorizontalLayout layout = new HorizontalLayout();

        Image white = new Image();
        white.setSource(new ThemeResource("img/white.jpg"));
        white.setWidth("170px");
        white.setHeight("145px");

        Image noImageAvailable = new Image();
        noImageAvailable.setSource(new ExternalResource("http://vignette3.wikia.nocookie.net/max-steel-reboot/images/7/72/No_Image_Available.gif/revision/latest?cb=20130902173013"));
        noImageAvailable.setWidth("170px");
        noImageAvailable.setHeight("145px");

        if (showOnlyOnePicture) {
            if (pictures == null) {
                layout.addComponent(noImageAvailable);
                layout.addComponent(white);
            } else {
                Image image = new Image();
                image.setSource(new ExternalResource(pictures.get(0)));
                image.setWidth("170px");
                image.setHeight("145px");
                layout.addComponent(image);
                layout.addComponent(white);
            }
        } else {

            setCaption("Pictures");
            setStyleName(".v-panel-caption");

            if (pictures == null) {
                layout.addComponent(noImageAvailable);
               // layout.addComponent(white);
            } else if (pictures.size() == 1) {

                Image image = new Image();
                image.setSource(new ExternalResource(pictures.get(0)));
                image.setWidth("350px");
                image.setHeight("315px");
                layout.addComponent(image);
                //layout.addComponent(white);

            } else {

                for (String picture : pictures) {
                    Image image = new Image();
                    image.setSource(new ExternalResource(picture));
                    image.setWidth("350px");
                    image.setHeight("315px");
                    layout.addComponent(image);
                }
            }
        }

        setContent(layout);
    }

}
