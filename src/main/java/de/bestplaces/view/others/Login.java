package de.bestplaces.view.others;

import com.vaadin.ui.*;
import de.bestplaces.MyUI;
import de.bestplaces.view.dashboard.DashboardUI;
import de.bestplaces.view.dashboard.components.Timeline;
import de.bestplaces.view.dashboard.view.DashboardView;
import de.bestplaces.view.dashboard.view.MainView;

/**
 * Created by franz on 24.11.2016.
 */
public class Login extends Window {

       public Login()
       {
           super("Login to BestPlaces");
           center();
           init();
       }

       public void init()
       {
           setWidth("25%");
           setHeight("30%");

           FormLayout form = new FormLayout();

           TextField userNameField = new TextField("Username");
           userNameField.setRequired(true);

           PasswordField passwordField = new PasswordField("Password");
           passwordField.setRequired(true);

           Button login = new Button("Login");
           login.addClickListener(new Button.ClickListener() {
               public void buttonClick(Button.ClickEvent event) {
                   checkUserData();
               }
           });

           form.addComponents(userNameField, passwordField, login);
           form.setSizeFull();
           form.setMargin(true);

           setContent(form);
       }

       //TODO: in Controller auslagern
       private void checkUserData()
       {
           //hier die Daten aus der Datenbank abfragen und auf Gleichheit prüfen
           //wenn richtig
           close();

           MyUI.getCurrent().setContent(new MainView());
       }
}