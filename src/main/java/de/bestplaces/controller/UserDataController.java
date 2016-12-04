package de.bestplaces.controller;

import de.bestplaces.model.User;
import de.bestplaces.view.others.RegistrationWindow;
import de.bestplaces.view.others.Success;

import java.util.Calendar;

/**
 * Created by franz on 25.11.2016.
 */
public class UserDataController {

    private RegistrationWindow registrationWindow;

    public UserDataController(RegistrationWindow registrationWindow)
    {
        this.registrationWindow = registrationWindow;

    }

    public void createUser()
    {
        String username =  (String) registrationWindow.getUserNameField().getData();

        String firstName = (String) registrationWindow.getFirstNameField().getData();
        String lastName = (String) registrationWindow.getLastNameField().getData();
        String email = "email";
        String password = (String) registrationWindow.getPasswordField().getData();
        String hometown = (String) registrationWindow.getHometownField().getData();

        User user = new User(username, firstName, lastName, email, password, hometown);

        registrationWindow.closeWindow();

        //TODO: verbindung zur Datenbank
    }

    public void saveDataChanges()
    {

    }

    public void removeUser()
    {

    }
}
