package de.bestplaces.view.dashboard.components;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import static de.bestplaces.MyUI.navigator;

/**
 * Created by franz on 25.11.2016.
 */
public class Search extends VerticalLayout implements View {
    public static final String SEARCH = "Search";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        init();
    }
    public void init()
    {
        HorizontalLayout layoutSearchBar = new HorizontalLayout();
        layoutSearchBar.setWidth("100%");

        Button backButton = new Button("Back");
        backButton.addClickListener(clickEvent -> navigator.navigateTo(Timeline.TIMELINE));

        TextField search = new TextField();
        search.setWidth("100%");
        search.setInputPrompt("Search for a place..");

        Button searchButton = new Button("Search");

        layoutSearchBar.addComponents(backButton, search, searchButton);
        layoutSearchBar.setComponentAlignment(backButton, Alignment.MIDDLE_LEFT);
        layoutSearchBar.setComponentAlignment(search, Alignment.MIDDLE_CENTER);
        layoutSearchBar.setComponentAlignment(searchButton, Alignment.MIDDLE_RIGHT);

        //loading the tilesView
        //TODO: das mus flexibel werden passend zur anzahl der suchergebnisse
        TilesView tileViewPanel = new TilesView();


        addComponent(layoutSearchBar);
        addComponent(tileViewPanel);
    }
}
