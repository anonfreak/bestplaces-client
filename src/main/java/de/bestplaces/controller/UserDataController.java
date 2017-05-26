package de.bestplaces.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.ui.Notification;
import de.bestplaces.model.User;
import de.bestplaces.view.dashboard.components.EditUserData;
import de.bestplaces.view.others.Login;
import de.bestplaces.view.others.RegistrationWindow;
import de.bestplaces.view.others.Success;
import elemental.json.Json;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by franz on 25.11.2016.
 */
public class UserDataController {

    private static String token = "";
    private static String username;

    public UserDataController()
    {
        this.initJackson();
        //token = "";
    }

    public boolean createUser(String username, String firstName, String lastName, String email, String password, String hometown) throws UnirestException {

        User user = new User(username, firstName, lastName, email, password, hometown);

        HttpResponse<String> response;

            response = Unirest.post("http://mathtap.de:1194/user/")
                    .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(user)
                    .asString();

        if(response.getStatus() == 201){
            return true;
        } else {

            return false;
        }
    }

    public boolean login(String username, String password) throws UnirestException {
        this.username = username;

        HttpResponse<JsonNode> response = Unirest.post("http://mathtap.de:1194/api-token-auth/").
                header("Accept", "application/json").
                field("username",username).
                field("password",password).asJson();
        if(response.getStatus() == 200){
            token = (String) response.getBody().getObject().get("token");
            //da steht das token drin. Drauf aufpassen
            return true;
        } else {
            return false;
        }

    }

    public User getUserData() throws UnirestException {
        HttpResponse<User> response = Unirest.get("http://mathtap.de:1194/user/" + username)
                .header("Authorization", "Token " + getToken())
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .asObject(User.class);

        User aktuellerUser = response.getBody();
        return aktuellerUser;
    }

    public boolean editUserData(String firstName, String lastName, String hometown, String email, String password) throws UnirestException {

        User user = new User(username, firstName, lastName, email, password, hometown);

        HttpResponse<JsonNode> response = Unirest.put("http://mathtap.de:1194/user/" + username + "/")
                .header("Authorization", "Token "+ getToken())
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(user)
                .asJson();

        return response.getStatus() == 200;
    }

    public boolean removeUser(String user) throws UnirestException {
        HttpResponse<String> response = Unirest.delete("http://mathtap.de:1194/user/" + user + "/")
                .header("Authorization", "Token " + getToken())
                .header("Accept", "application/json")
                .asString();

        token="";

        return response.getStatus() == 204;
    }

    public static String getToken(){
        if(token == ""){
            return "80f8d09d703f70f7a30c5ecba4428f6376c16d6d";
        }
        return token;
    }

    private void initJackson(){
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
