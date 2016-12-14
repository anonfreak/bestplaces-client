package de.bestplaces.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.ui.Notification;
import de.bestplaces.model.User;
import de.bestplaces.view.dashboard.components.EditUserData;
import de.bestplaces.view.others.Login;
import de.bestplaces.view.others.RegistrationWindow;
import de.bestplaces.view.others.Success;
import elemental.json.Json;

import java.util.Calendar;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by franz on 25.11.2016.
 */
public class UserDataController {

    private RegistrationWindow registrationWindow;
    private Login login;
    private EditUserData editUserData;

    private static String token;
    private static String username;

    public UserDataController(RegistrationWindow registrationWindow)
    {
        this.registrationWindow = registrationWindow;

    }

    public UserDataController(Login login)
    {
        this.login = login;

    }

    public UserDataController(EditUserData editUserData)
    {
        this.editUserData = editUserData;

    }

    public void createUser() throws UnirestException {
        String username =  registrationWindow.getUserNameField().getValue();

        String firstName = registrationWindow.getFirstNameField().getValue();
        String lastName = registrationWindow.getLastNameField().getValue();
        String email = "email";
        String password = registrationWindow.getPasswordField().getValue();
        String hometown = registrationWindow.getHometownField().getValue();

        User user = new User(username, firstName, lastName, email, password, hometown);

        HttpResponse<JsonNode> response;

            response = Unirest.post("http://mathtap.de:1194/user/")
                    .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(user)
                    .asJson();
        if(response.getStatus() == 201){
            registrationWindow.getUI().addWindow(new Success());
            registrationWindow.closeWindow();
        } else {
            Notification.show("Registration failed. Please try again.");
        }



    }

    public void login() throws UnirestException {
        username = login.getUserNameField().getValue();
        String password = login.getPasswordField().getValue();

        HttpResponse<JsonNode> response = Unirest.post("http://mathtap.de:1194/api-token-auth/").
                header("Accept", "application/json").
                field("username",username).
                field("password",password).asJson();
        if(response.getStatus() == 200){
            token = (String) response.getBody().getObject().get("token");
            //da steht das token drin. Drauf aufpassen
            login.closeWindow();
        } else {
            login.getPasswordField().setRequiredError("wrong password or username");

        }

    }

    public void getUserData() throws UnirestException {
        HttpResponse<User> response = Unirest.get("http://mathtap.de:1194/user/" + username)
                .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .asObject(User.class);

        User aktuellerUser = response.getBody();

        editUserData.getFirstNameField().setInputPrompt(aktuellerUser.getFirstName());
        editUserData.getLastNameField().setInputPrompt(aktuellerUser.getLastName());
        editUserData.getHometownField().setInputPrompt(aktuellerUser.getHometown());
        editUserData.getEmailField().setInputPrompt(aktuellerUser.getEmail());
    }

    public void editUserData() throws UnirestException {
        String firstName = editUserData.getFirstNameField().getValue();
        String lastName = editUserData.getLastNameField().getValue();
        String hometown = editUserData.getHometownField().getValue();
        String email = editUserData.getEmailField().getValue();
        String password = editUserData.getPasswordField().getValue();

        User user = new User(username, firstName, lastName, email, password, hometown);

        HttpResponse<JsonNode> response = Unirest.put("http://mathtap.de:1194/user/" + username + "/")
                .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(user)
                .asJson();

        if(response.getStatus() == 200){
            Notification.show("Changes successfully saved");
        } else {
            Notification.show("Error");
        }
    }

    public void removeUser()
    {

    }
}
