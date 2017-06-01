package de.bestplaces.view.dashboard.components;

import com.vaadin.ui.Panel;
import com.vaadin.ui.RichTextArea;
import de.bestplaces.model.FullPlace;

/**
 * Created by franz on 06.05.2017.
 */
public class OpeningHoursPanel extends Panel {

    private FullPlace place;
    private RichTextArea openingTime;

    public OpeningHoursPanel(FullPlace place) {

        this.place = place;
        setCaption("Opening Hours");
        setStyleName(".v-panel-caption");
        setSizeFull();

        setContent(getOpeningTime());

    }

    public RichTextArea getOpeningTime() {
        if(openingTime == null)
        {
            openingTime = new RichTextArea();

            if(place.getOpeningHours() == null)
            {
                openingTime.setValue("Sorry, no Opening Hours available!");
            } else {
                String open = "<p>";
                for (String day : place.getOpeningHours()) {
                    open = open + day + "</p>";
                    openingTime.setValue(open);
                }
            }
            openingTime.setReadOnly(true);
            openingTime.setSizeFull();
        }
        return openingTime;
    }

    public void setOpeningTime()
    {
        openingTime = null;
    }
}
