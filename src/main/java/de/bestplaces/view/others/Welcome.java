package de.bestplaces.view.others;

import com.vaadin.event.MouseEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Sizeable;
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

        Panel gross = new Panel();
        //gross.setSizeFull();
        gross.setHeight("576px");

        //Image above, Welcome Text and Buttons
        VerticalSplitPanel upPanel = new VerticalSplitPanel();
        gross.setContent(upPanel);
        upPanel.setStyleName("backgroundimage");

        //WelcomeUeberschrift
        Label welcomeLabel = new Label("Welcome to BestPlaces");
        welcomeLabel.setStyleName("v-label-stylename");

        HorizontalSplitPanel buttonPanel = new HorizontalSplitPanel();
        buttonPanel.setLocked(true);

        Button registerButton = new Button("Register Now");
        registerButton.addClickListener(clickEvent -> callRegistrationWindow());
        //VerticalLayout layoutFuerButton = new VerticalLayout();
        //Panel fuerButton = new Panel(layoutFuerButton);
        //layoutFuerButton.addComponent(registerButton);
        //layoutFuerButton.setComponentAlignment(registerButton, Alignment.MIDDLE_RIGHT);
        //layoutFuerButton.setStyleName("background");

        Button loginButton = new Button("Log In");
        loginButton.addClickListener(clickEvent -> callLoginWindow());

        buttonPanel.setSplitPosition(12, Sizeable.UNITS_PERCENTAGE);
        buttonPanel.setFirstComponent(registerButton);
        buttonPanel.setSecondComponent(loginButton);
        buttonPanel.setSizeFull();


        upPanel.setSplitPosition(90, Sizeable.UNITS_PERCENTAGE);
        upPanel.setLocked(true);
        upPanel.addComponent(welcomeLabel);
        upPanel.addComponent(buttonPanel);


        //Inhalt unter dem Bild
        HorizontalSplitPanel bottomPanel = new HorizontalSplitPanel();

        TextArea descriptionText = new TextArea("BestPlaces");
        descriptionText.setValue("Track your Favourite Places and discover more!\n" +
                                    "more Text");
        descriptionText.setReadOnly(true);
        descriptionText.setSizeFull();

        ThemeResource resource = new ThemeResource("img/Timeline.JPG");
        Image timelineImage = new Image("Timeline", resource);
        timelineImage.setSizeFull();

        bottomPanel.setSplitPosition(50, Sizeable.UNITS_PERCENTAGE);
        buttonPanel.setLocked(true);
        bottomPanel.setFirstComponent(descriptionText);
        bottomPanel.setSecondComponent(timelineImage);

        //Hinzufuegen zum zugrundeliegenden Layout
        layout.addComponent(gross);
        layout.addComponent(bottomPanel);


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
