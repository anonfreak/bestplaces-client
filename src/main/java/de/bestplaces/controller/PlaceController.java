package de.bestplaces.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.model.FullPlace;

import java.io.IOException;

/**
 * Created by franz on 29.11.2016.
 */
public class PlaceController {

    private static String token;

    public PlaceController()
    {
        this.initJackson();
        token = "";
    }

    public FullPlace getFullPlaceInformationToPlaceWithId(String placeId, String userId) throws UnirestException {

        //Request mit id
        HttpResponse<FullPlace> response = Unirest.get("http://mathtap.de:1194/place/" + placeId + "?userId=" + userId)
                .header("Authorization", "Token " + getToken())
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .asObject(FullPlace.class);

        FullPlace place = response.getBody();


        return place;
    }

    private String getToken(){
        if(token == ""){
            token = UserDataController.getToken();
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
