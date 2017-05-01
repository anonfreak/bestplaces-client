package de.bestplaces.view.others;

import com.vaadin.event.MouseEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.UserDataController;

/**
 * Created by franz on 25.11.2016.
 */
public class Welcome extends VerticalLayout implements View {
        public static final String WELCOME = "Welcome";
        private RegistrationWindow regWindow;
        private Login loginWindow;
        private NavigatorController navigatorController;

    public Welcome(NavigatorController controller)
    {
        navigatorController = controller;
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
        registerButton.addClickListener(clickEvent -> navigatorController.openWindow(new RegistrationWindow()));
        Button loginButton = new Button("Log In");
        loginButton.addClickListener(clickEvent -> navigatorController.openWindow(new Login()));

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

        RichTextArea descriptionText = new RichTextArea("BestPlaces");
        descriptionText.setValue("<h4>Track your Favourite Places and discover more!</h4>" +
                                    "<p>Not sure where to go for dinner? BestPlaces can show you, where you went, " +
                                    "what you ate and how you liked it. It can help you to plan trips and get an overview " +
                                    "about your personal favorites.</p>" +
                                    "<p>In you Timeline are all visited places. You can add personal information to each visit " +
                                    "just like how much money you spend, or with whom you went there. There is also the possibility" +
                                    " to show them all on a map.</p>" +
                                    "<p>So what are you waiting for? Register now for BestPlaces and start to track your Favorite Places! " +
                                    "- Totally free</p>");
        descriptionText.setReadOnly(true);
        descriptionText.setWidth("100%");
        descriptionText.setHeight("100%");

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

//        regWindow = new RegistrationWindow();
//        loginWindow = new Login();

    }

//    public void callRegistrationWindow()
//    {
//        loginWindow.close();
//        regWindow.setResizable(false);
//
//        this.getUI().addClickListener(new MouseEvents.ClickListener() {
//
//            @Override
//            public void click(MouseEvents.ClickEvent event) {
//                regWindow.close();
//            }
//        });
//
//        getUI().addWindow(regWindow);
//
//    }
//    public void callLoginWindow()
//    {
//        regWindow.close();
//        loginWindow.setResizable(false);
//
//        this.getUI().addClickListener(new MouseEvents.ClickListener() {
//            @Override
//            public void click(MouseEvents.ClickEvent clickEvent) {
//                loginWindow.close();
//            }
//        });
//
//        getUI().addWindow(loginWindow);
//    }
}
