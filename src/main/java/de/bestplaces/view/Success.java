package de.bestplaces.view;

import com.vaadin.ui.*;

/**
 * Created by franz on 24.11.2016.
 */
public class Success extends Window {

    public Success()
    {
        super("Success");
        center();
        init();

    }

    private void init()
    {
        setWidth("20%");
        setHeight("20%");

        VerticalLayout layout = new VerticalLayout();

        Label succesLabel = new Label("You are successfully registered.");
        Button loginButton = new Button("Login now");
        loginButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                getUI().addWindow(new Login());
                close();
            }});

        layout.addComponents(succesLabel, loginButton);
        layout.setMargin(true);
        setContent(layout);

    }
}
