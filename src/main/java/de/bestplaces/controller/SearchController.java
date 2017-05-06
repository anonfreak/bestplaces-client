package de.bestplaces.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.navigator.View;
import de.bestplaces.model.Adress;
import de.bestplaces.model.Place;
import de.bestplaces.model.User;
import gherkin.lexer.Pl;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by franz on 03.05.2017.
 */
public class SearchController {

    private static String token;
    private UserDataController userDataController;

    public SearchController(UserDataController userDataController)
    {
        this.userDataController = userDataController;
        this.initJackson();
        token = "";
    }

    public List<Place> search(String place, String town) throws UnirestException {

        HttpResponse<Place[]> response = Unirest.get("http://mathtap.de:1194/place/search?q=" + place + "&location=" + town)
                .header("Authorization", "Token " + getToken())
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .asObject(Place[].class);

        List<Place> placesList = new ArrayList<>();

        Place[] placeArray = response.getBody();

        for (int i = 0; i < placeArray.length; i++) {
            placesList.add(placeArray[i]);
        }

        return placesList;
    }

    public void searchMore()
    {

    }


    private String getToken(){
        if(token == ""){
            token = userDataController.getToken();
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
