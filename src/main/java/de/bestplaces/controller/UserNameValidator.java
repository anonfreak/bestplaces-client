package de.bestplaces.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.data.Validator;
import com.vaadin.ui.Notification;
import de.bestplaces.model.User;

/**
 * Created by franz on 23.04.2017.
 */
public class UserNameValidator implements Validator {

    boolean isValid = true;

    public UserNameValidator()
    {

    }

    @Override
    public void validate(Object o) throws InvalidValueException {

        String username = o.toString();
        try {

            HttpResponse<JsonNode> response = Unirest.get("http://mathtap.de:1194/user/"+username+"/")
                    .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .asJson();

            if(response.getStatus() == 200){
                isValid=false;
            }

        } catch (UnirestException e) {
            e.printStackTrace();
            Notification.show("Sorry, I can't reach the Server");
        }
    }

    public boolean isValid() {
        return isValid;
    }
}
