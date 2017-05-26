package de.bestplaces.view.dashboard.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import de.bestplaces.model.FullPlace;

/**
 * Created by franz on 06.05.2017.
 */
public class RatingPanel extends Panel {

    FullPlace place;
    RichTextArea contentTextArea;
    Label stars;

    public RatingPanel(FullPlace place) {
        this.place = place;

        setCaption("Ratings");
        setStyleName(".v-panel-caption");
        setSizeFull();
        VerticalLayout layout = new VerticalLayout();
        layout.addComponents(getContentTextArea());
        setContent(layout);
    }

    public Label getStars() {

        HorizontalLayout starLayout = new HorizontalLayout();
        for (int i = 0; i < place.getAverageStar() ; i++) {

            stars = new Label(FontAwesome.STAR.getHtml() + "");
            stars.setContentMode(ContentMode.HTML);
            starLayout.addComponent(stars);
        }


        return stars;
    }


    public RichTextArea getContentTextArea() {
        if (contentTextArea == null) {

            //int stars = place.getReview().getStars();
            //String saying = place.getReview().getText();
            //boolean showName = place.getReview().isShowName();

            contentTextArea = new RichTextArea();
            contentTextArea.setSizeFull();
            contentTextArea.setValue("Space for opinions about this place");
            contentTextArea.setStyleName("borderless");
            contentTextArea.setReadOnly(true);
        }

        return contentTextArea;
    }
}
