package de.bestplaces.view.dashboard.components;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.data.validator.DoubleValidator;
import com.vaadin.data.validator.IntegerValidator;
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
        this.setId("editVisitWindow");
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
        spendMoneyField.addValidator(new DoubleValidator("Input must be like 4.50"));
        spendMoneyField.setValidationVisible(true);
        spendMoneyField.setId("moneyField");

        spendTimeField = new TextField("Spend Time (in min)");
        spendTimeField.setValue(String.valueOf(visit.getDuration()));
        spendTimeField.addValidator(new IntegerValidator("Input must be like 50"));
        spendTimeField.setValidationVisible(true);

        notesField = new TextArea("Notes");
        notesField.setValue(visit.getNotes());

        saveChanges = new Button("Save Changes");
        saveChanges.setId("saveButton");
        saveChanges.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Visit visit = getFields();
                VisitController visitController = navigatorController.getVisitController();
                try {
                    Visit succesfull = visitController.updateVisit(visit);
                    if (!succesfull.getPlaceId().equals(""))
                    {
                        navigatorController.setVisit(succesfull, fullPlace);
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
