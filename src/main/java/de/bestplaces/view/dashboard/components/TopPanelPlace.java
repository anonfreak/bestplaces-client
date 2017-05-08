package de.bestplaces.view.dashboard.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import de.bestplaces.model.FullPlace;

/**
 * Created by franz on 06.05.2017.
 */
public class TopPanelPlace extends Panel {

    Button backButton;
    Label name;
    Button addToTimeline;
    Button addToFavorite;

    FullPlace place;

    public TopPanelPlace(FullPlace place) {

        this.place = place;
        HorizontalLayout layout = new HorizontalLayout();
        layout.setMargin(false);
        layout.setSizeFull();
        layout.addComponents(getBackButton(), getName(), getAddToTimeline(), getAddToFavorite());

        layout.setExpandRatio(getBackButton(), 0.1f);
        layout.setExpandRatio(getName(), 0.7f);
        layout.setExpandRatio(getAddToTimeline(), 0.1f);
        layout.setExpandRatio(getAddToFavorite(), 0.1f);

        setContent(layout);
    }

    public Button getBackButton() {
        if(backButton == null)
        {
            backButton = new Button("back", FontAwesome.ARROW_LEFT);
            backButton.setSizeFull();
        }
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Label getName() {
        if(name == null)
        {
            name = new Label(place.getName());
            name.setStyleName("huge");
            name.setSizeFull();
        }
        return name;
    }

    public void setName(Label name) {
        this.name = name;
    }

    public Button getAddToTimeline() {
        if(addToTimeline == null)
        {
            addToTimeline = new Button(FontAwesome.CALENDAR);
            addToTimeline.setSizeFull();
        }
        return addToTimeline;
    }

    public void setAddToTimeline(Button addToTimeline) {
        this.addToTimeline = addToTimeline;
    }

    public Button getAddToFavorite() {

        FontAwesome icon = FontAwesome.HEART_O;

        if(place.isFavorite())
        {
            icon = FontAwesome.HEART;
        }

        if(addToFavorite== null)
        {
            addToFavorite = new Button(icon);
            addToFavorite.setDescription("Add this place to your personal Favorites");
            addToFavorite.setSizeFull();
        }
        return addToFavorite;
    }

    public void setAddToFavorite(Button addToFavorite) {
        this.addToFavorite = addToFavorite;
    }
}
