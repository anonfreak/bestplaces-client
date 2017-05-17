package de.bestplaces.view.dashboard.components;

import com.vaadin.ui.*;
import de.bestplaces.model.Address;
import de.bestplaces.model.FullPlace;

/**
 * Created by franz on 06.05.2017.
 */
public class AddressPanel extends Panel {

    HorizontalSplitPanel addressSplitPanel;
    RichTextArea contactPanel;
    RichTextArea addressLabel;
    FullPlace place;

    public AddressPanel(FullPlace place) {

        this.place = place;
        setSizeFull();
        setCaption("Location information");
        setStyleName(".v-panel-caption");
        VerticalSplitPanel layout = new VerticalSplitPanel();
        layout.setSizeFull();

        layout.addComponent(getAddressSplitPanel());
        layout.addComponent(getContactPanel());
        layout.setSplitPosition(70);

        setContent(layout);
    }

    public HorizontalSplitPanel getAddressSplitPanel() {
        if (addressSplitPanel == null)
        {
            addressSplitPanel = new HorizontalSplitPanel();
            addressSplitPanel.setFirstComponent(new GoogleMapsPanel(place));
            addressSplitPanel.setSecondComponent(getAddressLabel());
            addressSplitPanel.setSplitPosition(70);
            addressSplitPanel.setSizeFull();
        }

        return addressSplitPanel;
    }

    public RichTextArea getContactPanel() {

        if(contactPanel == null)
        {
            contactPanel = new RichTextArea();
            contactPanel.setSizeFull();
            contactPanel.setValue("<p> Website: " + place.getWebsite() + "</p>" +
                    "<p> Phone number: " + place.getPhonenumber() + "</p>");
            contactPanel.setReadOnly(true);
        }
        return contactPanel;
    }

    public RichTextArea getAddressLabel() {
        if(addressLabel==null)
        {
            Address address = place.getAddress();
            addressLabel = new RichTextArea("Address");
            addressLabel.setValue("<h3> Address </h3> <p>" + address.getStreet() + " " + address.getHouseNumber() + "</p>" +
            "<p>" + address.getZipCode() + " " + address.getTown() + "</p>");
            addressLabel.setReadOnly(true);
            addressLabel.setWidth("100%");
            addressLabel.setHeight("100%");
        }
        return addressLabel;
    }
}
