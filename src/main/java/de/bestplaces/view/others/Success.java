package de.bestplaces.view.others;

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
        Panel panel = new Panel();
        VerticalLayout layout = new VerticalLayout();

        Label succesLabel = new Label("You are successfully registered.");
        Button loginButton = new Button("Login now");
        loginButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {

                Login loginWindow = new Login();
                loginWindow.setResizable(false);
                getUI().addWindow(loginWindow);
                close();
            }});

        layout.addComponents(succesLabel, loginButton);
        layout.setMargin(true);

        panel.setContent(layout);
        panel.getContent().setSizeUndefined();

        setContent(panel);

    }
}
