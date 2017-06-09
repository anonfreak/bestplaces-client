package de.bestplaces.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.model.Visit;
import de.bestplaces.model.VisitResults;

import java.io.IOException;
import java.util.List;

/**
 * Created by franz on 29.11.2016.
 */
public class VisitController {


    private static String token = "";

    public VisitController()
    {
        this.initJackson();
    }

    public boolean addVisitToTimeline(Visit testVisit) throws UnirestException {

        HttpResponse<JsonNode> response = Unirest.post("http://mathtap.de:1194/visit/")
                .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(testVisit)
                .asJson();

        return response.getStatus() == 201;

    }

    public List<Visit> getVisits(String username) throws UnirestException {
        HttpResponse<VisitResults> response = Unirest.get("http://mathtap.de:1194/visit?username=" + username)
                .header("Authorization", "Token " + UserDataController.getToken())
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .asObject(VisitResults.class);

        VisitResults results = response.getBody();
        List<Visit> visitList = results.getResults();
        return visitList;
    }

    public boolean updateVisit()
    {
        return true;
    }

    public static String getToken(){
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
