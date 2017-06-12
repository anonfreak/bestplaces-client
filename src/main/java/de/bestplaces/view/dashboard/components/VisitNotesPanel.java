package de.bestplaces.view.dashboard.components;

import com.vaadin.ui.Panel;
import com.vaadin.ui.RichTextArea;
import de.bestplaces.model.Visit;

/**
 * Created by franzi on 09.06.2017.
 */
public class VisitNotesPanel extends Panel {

    private Visit visit;
    private RichTextArea visitNotes;

    public VisitNotesPanel(Visit visit) {

        this.visit = visit;
        setCaption("Notes");
        setStyleName(".v-panel-caption");
        setSizeFull();

        setContent(getVisitNotes());

    }

    public RichTextArea getVisitNotes() {
        if(visitNotes == null)
        {
            visitNotes = new RichTextArea();
            //String notes = "No Notes available!";
            //if (visit.getNotes() != null)

                String notes = visit.getNotes();

            visitNotes.setValue("<p>" + notes + "</p>");

            visitNotes.setReadOnly(true);
            visitNotes.setSizeFull();
        }
        return visitNotes;
    }
}
