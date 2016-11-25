package de.bestplaces.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

/**
 * Created by franz on 25.11.2016.
 */
public class Welcome extends VerticalLayout implements View {
        public static final String WELCOME = "Welcome";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        init();
    }

    private void init()
    {
        VerticalLayout layout = new VerticalLayout();
        Label welcomeLabel = new Label("Welcome to BestPlaces");
        welcomeLabel.setWidth("170px");
        layout.addComponent(welcomeLabel);

        HorizontalLayout panelLayout = new HorizontalLayout();
        Panel welcomePanel = new Panel();

        Button registerButton = new Button("Register Now");
        registerButton.addClickListener(clickEvent -> callRegistrationWindow());
        Button loginButton = new Button("Log In");
        loginButton.addClickListener(clickEvent -> callLoginWindow());

        panelLayout.addComponent(registerButton);
        panelLayout.addComponent(loginButton);
        panelLayout.setSpacing(true);
        panelLayout.setSizeUndefined();

        welcomePanel.setContent(panelLayout);
        welcomePanel.setSizeUndefined();

        layout.addComponent(welcomePanel);

        layout.setMargin(true);
        layout.setComponentAlignment(welcomeLabel, Alignment.TOP_CENTER);
        layout.setComponentAlignment(welcomePanel, Alignment.MIDDLE_CENTER);
        layout.setSpacing(true);

        addComponent(layout);

    }

    public void callRegistrationWindow()
    {
        getUI().addWindow(new RegistrationWindow());

    }
    public void callLoginWindow()
    {
        getUI().addWindow(new Login());
    }
}
