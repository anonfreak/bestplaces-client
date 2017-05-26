package de.bestplaces.view.dashboard.components;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.data.Property;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.*;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.VisitController;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Visit;
import de.bestplaces.view.others.CustomizedWindow;

import java.util.Date;

/**
 * Created by franzi on 25.05.2017.
 */
public class DatePicker extends CustomizedWindow {

    private Date date;
    private FullPlace place;
    private NavigatorController navigatorController;

    public DatePicker(FullPlace place, NavigatorController navigatorController) {
        super("Choose Date");
        this.place = place;
        this.navigatorController = navigatorController;
        center();
        setResizable(false);
        init();

    }

    private void init()
    {
        Panel panel = new Panel();
        VerticalLayout layout = new VerticalLayout();

        InlineDateField datePicker = new InlineDateField("Choose Visit Time");
        Date dateToday = new Date();
        datePicker.setValue(dateToday);
        datePicker.setResolution(Resolution.MINUTE);
        datePicker.setDateFormat("yyyy/MM/dd");

        datePicker.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                date = (Date) valueChangeEvent.getProperty().getValue();
            }
        });

        panel.setContent(datePicker);

        Label dateLabel = new Label();
        Button choose = new Button("Choose");
        choose.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                //Sat May 27 21:34:04 CEST 2017
                dateLabel.setValue(date.toString());

                // verbindung zur API und speichern! Danach winow schließen

                Visit visit = new Visit(place.getPlaceID(), navigatorController.getUserDataController().getUsername() ,
                        date, 0.0, null);
                VisitController visitController = navigatorController.getVisitController();
                try {
                    boolean saved = visitController.addVisitToTimeline(visit);
                    if(saved)
                    {
                        close();
                    } else
                    {
                        Notification.show("Sorry, this doesn't work. Try again.");
                    }

                } catch (UnirestException e) {
                    e.printStackTrace();
                }
            }
        });


        layout.addComponent(datePicker);
        layout.addComponent(choose);
        layout.addComponent(dateLabel);

        setContent(layout);

    }

}
