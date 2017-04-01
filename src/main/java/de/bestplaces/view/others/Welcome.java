package de.bestplaces.view.others;

import com.vaadin.event.MouseEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

/**
 * Created by franz on 25.11.2016.
 */
public class Welcome extends VerticalLayout implements View {
        public static final String WELCOME = "Welcome";
        private RegistrationWindow regWindow;
        private Login loginWindow;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        init();
    }

    private void init()
    {
        VerticalLayout layout = new VerticalLayout();
        Label welcomeLabel = new Label("Welcome to BestPlaces");
        welcomeLabel.setWidth("280px");
        welcomeLabel.setStyleName("huge");
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

        regWindow = new RegistrationWindow();
        loginWindow = new Login();

    }

    public void callRegistrationWindow()
    {
        loginWindow.close();
        regWindow.setResizable(false);

        this.getUI().addClickListener(new MouseEvents.ClickListener() {

            @Override
            public void click(MouseEvents.ClickEvent event) {
                regWindow.close();
            }
        });

        getUI().addWindow(regWindow);

    }
    public void callLoginWindow()
    {
        regWindow.close();
        loginWindow.setResizable(false);

        this.getUI().addClickListener(new MouseEvents.ClickListener() {
            @Override
            public void click(MouseEvents.ClickEvent clickEvent) {
                loginWindow.close();
            }
        });

        getUI().addWindow(loginWindow);
    }
}
