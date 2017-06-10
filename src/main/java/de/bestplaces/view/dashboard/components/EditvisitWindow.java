package de.bestplaces.view.dashboard.components;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.ui.*;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.VisitController;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Visit;
import de.bestplaces.view.others.CustomizedWindow;

/**
 * Created by franzi on 09.06.2017.
 */
public class EditvisitWindow extends CustomizedWindow {

    private Panel panel;
    private FormLayout layout;

    private TextField spendMoneyField;
    private TextField spendTimeField;
    private TextArea notesField;

    private Button saveChanges;

    private Visit visit;
    private NavigatorController navigatorController;
    private FullPlace fullPlace;

    public EditvisitWindow(Visit visit, NavigatorController navigatorController, FullPlace fullPlace)
    {
        super("Edit Visit Information");
        this.visit=visit;
        this.navigatorController=navigatorController;
        this.fullPlace = fullPlace;
        center();
        setResizable(false);
        init();
    }

    public void init()
    {
        panel = new Panel();
        layout = new FormLayout();

        spendMoneyField = new TextField("Spend Money");
        spendMoneyField.setValue(String.valueOf(visit.getMoney()));
        spendMoneyField.focus();
        spendTimeField = new TextField("Spend Time");
        //TODO: Sobal duration dabei ist, das hier ändern!!!!
        spendTimeField.setValue(visit.getFormattedVisitTime());
        notesField = new TextArea("Notes");
        notesField.setValue(visit.getNotes());

        saveChanges = new Button("Save Changes");
        saveChanges.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Visit visit = getFields();
                VisitController visitController = navigatorController.getVisitController();
                try {
                    boolean succesfull = visitController.updateVisit(visit);
                    if (succesfull)
                    {
                        navigatorController.setVisit(visit, fullPlace);
                        navigatorController.switchToView("VisitView");
                        close();
                    }else
                    {
                        Notification.show("Sorry, this doesn't work!");
                    }
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
            }
        });

        layout.addComponents(spendMoneyField, spendTimeField, notesField, saveChanges);
        layout.setSizeFull();
        layout.setMargin(true);

        panel.setContent(layout);
        panel.getContent().setSizeUndefined();

        setContent(panel);
    }

    private Visit getFields()
    {
        String money = spendMoneyField.getValue();
        String duration = spendTimeField.getValue();
        String notes = notesField.getValue();

        visit.setMoney(Double.valueOf(money));
        visit.setDuration(Integer.valueOf(duration));
        visit.setNotes(notes);

        return visit;
    }
}
