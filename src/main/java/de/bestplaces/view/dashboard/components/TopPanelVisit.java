package de.bestplaces.view.dashboard.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Pages;

/**
 * Created by franzi on 09.06.2017.
 */
public class TopPanelVisit extends Panel {

    private Button backButton;
    private Label name;
    private Button addToFavorite;
    private Button editVisit;
    private Button removeVisit;

    private FullPlace place;
    private NavigatorController navigatorController;

    public TopPanelVisit(FullPlace place, NavigatorController navigatorController) {

        this.place = place;
        this.navigatorController = navigatorController;
        HorizontalLayout layout = new HorizontalLayout();
        layout.setMargin(false);
        layout.setSizeFull();
        layout.addComponents(getBackButton(), getName(), getAddToFavorite(), getEditVisit(), getRemoveVisit());

        layout.setExpandRatio(getBackButton(), 0.1f);
        layout.setExpandRatio(getName(), 0.6f);
        //layout.setExpandRatio(getAddToTimeline(), 0.1f);
        layout.setExpandRatio(getAddToFavorite(), 0.1f);
        layout.setExpandRatio(getEditVisit(), 0.1f);
        layout.setExpandRatio(getRemoveVisit(), 0.1f);

        setContent(layout);
    }

    public Button getBackButton() {
        if(backButton == null)
        {
            backButton = new Button("back", FontAwesome.ARROW_LEFT);
            backButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    navigatorController.setVisitViewBack();
                    navigatorController.switchToView(Pages.TIMELINE);
                }
            });
            backButton.setSizeFull();
        }
        return backButton;
    }

    public Label getName() {
        if(name == null)
        {
            name = new Label();
            if((place.getName().length() != 0) && (place.getName() != null))
            {
                name.setValue("<b>" + place.getName() + "<b>");
            }
            name.setContentMode(ContentMode.HTML);
            name.setSizeFull();
        }
        return name;
    }

    public void setName(Label name) {
        this.name = name;
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

    public Button getEditVisit() {
        if (editVisit == null)
        {
            FontAwesome icon = FontAwesome.EDIT;
            editVisit = new Button(icon);
            editVisit.setDescription("Edit");
            editVisit.setSizeFull();
        }
        return editVisit;
    }

    public Button getRemoveVisit() {
        if(removeVisit == null)
        {
            FontAwesome icon = FontAwesome.REMOVE;
            removeVisit = new Button(icon);
            removeVisit.setDescription("Remove Visit");
            removeVisit.setSizeFull();
        }
        return removeVisit;
    }
}
