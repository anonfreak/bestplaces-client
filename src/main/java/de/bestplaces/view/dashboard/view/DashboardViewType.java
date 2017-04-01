package de.bestplaces.view.dashboard.view;

/**
 * Created by franz on 28.11.2016.
 */

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import de.bestplaces.view.dashboard.components.EditUserData;
import de.bestplaces.view.dashboard.components.Search;
import de.bestplaces.view.dashboard.components.Timeline;

public enum DashboardViewType {

    TIMELINE("timeline", Timeline.class, FontAwesome.HOME, false),
    SEARCH("search", Search.class, FontAwesome.SEARCH, false),
    EDITUSERDATA("Edit User Data", EditUserData.class, FontAwesome.EDIT, false);

    private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean stateful;

    private DashboardViewType(final String viewName,
                              final Class<? extends View> viewClass, final Resource icon,
                              final boolean stateful) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
    }

    public boolean isStateful() {
        return stateful;
    }

    public String getViewName() {
        return viewName;
    }

    public Class<? extends View> getViewClass() {
        return viewClass;
    }

    public Resource getIcon() {
        return icon;
    }

    public static DashboardViewType getByViewName(final String viewName) {
        DashboardViewType result = null;
        for (DashboardViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }

}
