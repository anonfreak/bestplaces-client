package de.bestplaces.view.others;

import com.vaadin.event.MouseEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

/**
 * Created by franz on 25.11.2016.
 */
public class Welcome extends VerticalLayout implements View {
        public static final String WELCOME = "Welcome";
        private RegistrationWindow regWindow;
        private Login loginWindow;

    public Welcome()
    {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        init();
    }

    private void init()
    {
        //Grundlayout
        VerticalLayout layout = new VerticalLayout();

        //WelcomeUeberschrift
        Label welcomeLabel = new Label("Welcome to BestPlaces");
        welcomeLabel.setStyleName("v-label-stylename");

        //Buttons
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
        panelLayout.setStyleName("background");

        welcomePanel.setContent(panelLayout);
        welcomePanel.setSizeUndefined();

        //Panel, welches alles zusammenfasst
        VerticalLayout backroundLayout = new VerticalLayout();
        Panel backround = new Panel(backroundLayout);
        backroundLayout.addComponent(welcomeLabel);
        backroundLayout.addComponent(welcomePanel);
        backroundLayout.setStyleName("backgroundimage");
        backroundLayout.setSizeFull();
        backroundLayout.setComponentAlignment(welcomeLabel, Alignment.TOP_CENTER);
        backroundLayout.setComponentAlignment(welcomePanel, Alignment.MIDDLE_CENTER);
        backround.setHeight("576px");
        backround.setWidth("1024px");

        //Inhalt unter dem Bild
        GridLayout contentLayout = new GridLayout(2,1);
        Panel contentPanel = new Panel(contentLayout);
        contentLayout.setColumnExpandRatio(0,1);
        contentLayout.setColumnExpandRatio(1,1);

        TextArea descriptionText = new TextArea("BestPlaces");
        descriptionText.setValue("Track your Favourite Places and discover more!\n" +
                                    "more Text");
        descriptionText.setReadOnly(true);
        descriptionText.setSizeFull();

        ThemeResource resource = new ThemeResource("img/Timeline.JPG");
        Image timelineImage = new Image("Timeline", resource);
        timelineImage.setHeight("200px");
        timelineImage.setWidth("300px");

        contentLayout.addComponent(descriptionText,0,0);
        contentLayout.addComponent(timelineImage,1,0);

        contentLayout.setComponentAlignment(descriptionText, Alignment.BOTTOM_LEFT);
        contentLayout.setComponentAlignment(timelineImage, Alignment.BOTTOM_RIGHT);

        //Hinzufuegen zum zugrundeliegenden Layout
        layout.addComponent(backround);
        layout.addComponent(contentPanel);

        layout.setMargin(true);
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
