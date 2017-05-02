package de.bestplaces.model;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import org.apache.regexp.RE;

/**
 * Created by kolbm on 01.05.2017.
 */
public enum Pages {
    TIMELINE("Timeline", FontAwesome.HOME), SEARCH("Search", FontAwesome.SEARCH), EDITUSERDATA("EditUserData", FontAwesome.EDIT);

    private final String text;
    private final Resource icon;

    /**
     * @param text
     */
    private Pages(final String text, final Resource icon) {
        this.text = text;
        this.icon = icon;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }

    public Resource getIcon(){ return icon;}
}
