package de.bestplaces.view.dashboard.components;

import com.vaadin.ui.*;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.VisitController;
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

    public EditvisitWindow(Visit visit, NavigatorController navigatorController)
    {
        super("Edit Visit Information");
        this.visit=visit;
        this.navigatorController=navigatorController;
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
                VisitController visitController = navigatorController.getVisitController();
                visitController.updateVisit();
            }
        });

        layout.addComponents(spendMoneyField, spendTimeField, notesField, saveChanges);
        layout.setSizeFull();
        layout.setMargin(true);

        panel.setContent(layout);
        panel.getContent().setSizeUndefined();

        setContent(panel);
    }
}
