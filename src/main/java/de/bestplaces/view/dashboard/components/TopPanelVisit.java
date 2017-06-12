package de.bestplaces.view.dashboard.components;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.VisitController;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Pages;
import de.bestplaces.model.Visit;
import gherkin.lexer.Pa;
import gherkin.lexer.Vi;

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
    private Visit visit;

    public TopPanelVisit(FullPlace place, NavigatorController navigatorController, Visit visit) {

        this.place = place;
        this.navigatorController = navigatorController;
        this.visit = visit;
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
            editVisit.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    navigatorController.openWindow(new EditvisitWindow(visit, navigatorController, place));
                }
            });
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
            removeVisit.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    VisitController visitController = navigatorController.getVisitController();
                    try {
                        boolean success = visitController.deleteVisit(visit);
                        if (success)
                        {
                            navigatorController.switchToView(Pages.TIMELINE);
                        } else
                        {
                            Notification.show("Sorry, this doesn't work!");
                        }
                    } catch (UnirestException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return removeVisit;
    }
}
