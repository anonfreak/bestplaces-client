package de.bestplaces.view.others;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.ui.*;
import de.bestplaces.MyUI;
import de.bestplaces.controller.UserDataController;
import de.bestplaces.view.dashboard.view.MainView;

/**
 * Created by franz on 24.11.2016.
 */
public class Login extends Window {
    private TextField userNameField;
    private PasswordField passwordField;
    private UserDataController userDataController;


    public Login()
       {
           super("Login to BestPlaces");
           center();
           userDataController = new UserDataController(this);
           init();
       }

       public void init()
       {
           setWidth("25%");
           setHeight("30%");

           FormLayout form = new FormLayout();

           userNameField = new TextField("Username");
           userNameField.setRequired(true);

           passwordField = new PasswordField("Password");
           passwordField.setRequired(true);

           Button login = new Button("Login");
           login.addClickListener(new Button.ClickListener() {
               public void buttonClick(Button.ClickEvent event) {
                   try {
                       userDataController.login();
                   } catch (UnirestException e) {
                       e.printStackTrace();
                   }
               }
           });

           form.addComponents(userNameField, passwordField, login);
           form.setSizeFull();
           form.setMargin(true);

           setContent(form);
       }


       public void closeWindow()
       {
           close();

           MyUI.getCurrent().setContent(new MainView());
       }


    public TextField getUserNameField() {
        return userNameField;
    }

    public void setUserNameField(TextField userNameField) {
        this.userNameField = userNameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }
}
