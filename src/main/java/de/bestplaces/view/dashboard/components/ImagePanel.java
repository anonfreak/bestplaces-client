package de.bestplaces.view.dashboard.components;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
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

        Image white = new Image();
        white.setSource(new ThemeResource("img/white.jpg"));
        white.setWidth("170px");
        white.setHeight("145px");

        if(pictures == null)
        {
            Image image = new Image();
            image.setSource(new ExternalResource("http://vignette3.wikia.nocookie.net/max-steel-reboot/images/7/72/No_Image_Available.gif/revision/latest?cb=20130902173013"));
            image.setWidth("170px");
            image.setHeight("145px");
            layout.addComponent(image);
            layout.addComponent(white);
        } else

        if(pictures.size() == 1) {

            Image image = new Image();
            image.setSource(new ExternalResource(pictures.get(0)));
            image.setWidth("170px");
            image.setHeight("145px");
            layout.addComponent(image);
            layout.addComponent(white);

        } else{

            for (String picture : pictures) {
                Image image = new Image();
                image.setSource(new ExternalResource(picture));
                image.setWidth("170px");
                image.setHeight("145px");
                layout.addComponent(image);
            }
        }

        setContent(layout);
    }

}
