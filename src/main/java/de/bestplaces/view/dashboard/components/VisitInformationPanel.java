package de.bestplaces.view.dashboard.components;

import com.vaadin.ui.Panel;
import com.vaadin.ui.RichTextArea;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Visit;

/**
 * Created by franzi on 09.06.2017.
 */
public class VisitInformationPanel extends Panel {

    private Visit visit;
    private RichTextArea visitInformation;

    public VisitInformationPanel(Visit visit) {

        this.visit = visit;
        setCaption("Visit Information");
        setStyleName(".v-panel-caption");
        setSizeFull();

        setContent(getVisitInformation());

    }

    public RichTextArea getVisitInformation() {
        if(visitInformation == null)
        {
            visitInformation = new RichTextArea();
            visitInformation.setValue("<p>Spend time: " + getDuration() + "</p>" +
                                        "<p>Spend Money: " + getSpendMoney() + "</p>");

            visitInformation.setReadOnly(true);
            visitInformation.setSizeFull();
        }
        return visitInformation;
    }

    private String getDuration()
    {
        //TODO: rauslöschen, wenn implementiert
        visit.setDuration(90);
        return String.valueOf(visit.getDuration());
    }

    private String getSpendMoney(){

        return String.valueOf(visit.getMoney());
    }

}
