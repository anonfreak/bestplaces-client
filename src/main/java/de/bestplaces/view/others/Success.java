package de.bestplaces.view.others;

import com.vaadin.ui.*;

/**
 * Created by franz on 24.11.2016.
 */
public class Success extends CustomizedWindow {

    public Success()
    {
        super("Success");
        this.setId("succesWindow");
        center();
        setResizable(false);
        init();

    }

    private void init()
    {
        Panel panel = new Panel();
        VerticalLayout layout = new VerticalLayout();

        Label succesLabel = new Label("You are successfully registered.");
        Button loginButton = new Button("Login now");
        loginButton.setId("login");
        loginButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                navigatorController.openWindow(new Login());
                close();
            }});

        layout.addComponents(succesLabel, loginButton);
        layout.setMargin(true);

        panel.setContent(layout);
        panel.getContent().setSizeUndefined();

        setContent(panel);

    }
}
