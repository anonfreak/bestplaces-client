package de.bestplaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.controller.UserDataController;
import de.bestplaces.model.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.DataInput;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by franz on 02.12.2016.
 */
public class testRestAPI {

    Visit testVisit;

    @Before
    public void setMappers(){
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

    @Ignore
    @Test
    public void createUserTest() throws UnirestException {
        User testUser = new User("iskaNeumann", "Franziska", "Neumann", "shaundasschaf.neumann@gmx.de", "1234", "Karlsruhe");
        HttpResponse<JsonNode> response = Unirest.post("http://mathtap.de:1194/user/")
                .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(testUser)
                .asJson();
        assertEquals(201, response.getStatus());
    }

    @Ignore
    @Test
    public void authenticate() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post("http://mathtap.de:1194/api-token-auth/").
                header("Accept", "application/json").
                field("username","iskaNeumann").
                field("password","1234").asJson();
        assertEquals(200, response.getStatus());

    }

    @Ignore
    @Test
    public void getUserData() throws UnirestException {
        HttpResponse<User> response = Unirest.get("http://mathtap.de:1194/user/kolbma")
                .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .asObject(User.class);
        assertEquals(200, response.getStatus());
    }

    @Ignore
    @Test
    public void editUserTest() throws UnirestException {
        User testUser = new User("iskaNeumann", "Franziska", "Neumann", "shaundasschaf.neumann@gmail.com", "1234", "Karlsruhe");
        HttpResponse<JsonNode> response = Unirest.put("http://mathtap.de:1194/user/iskaNeumann/")
                .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(testUser)
                .asJson();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void search() throws UnirestException {

        HttpResponse<SearchResults> response = Unirest.get("http://mathtap.de:1194/place/search")
                .queryString("q", "Pizza")
                .queryString("location", "Karlsruhe")
                .header("Authorization", "Token " + UserDataController.getToken())
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .asObject(SearchResults.class);

        SearchResults results = response.getBody();

        List<Place> placesList = results.getResults();

        assertEquals(200, response.getStatus());
    }

    @Test
    public void addVisitToTimelineTest() throws UnirestException {

        Date date = new Date();
        date.setTime(1495742164);
        testVisit = new Visit("ChIJd_6tlTcGl0cRVpRkbna3w68", "test", date, 10, "Sehr lecker");

        HttpResponse<JsonNode> response = Unirest.post("http://mathtap.de:1194/visit/")
                .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(testVisit)
                .asJson();
        assertEquals(201, response.getStatus());
    }

    @Test
    public void getVisitsofUser() throws UnirestException, IOException {

        HttpResponse<VisitResults> response = Unirest.get("http://mathtap.de:1194/visit?username=test")
                .header("Authorization", "Token " + UserDataController.getToken())
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .asObject(VisitResults.class);

        VisitResults results = response.getBody();
        List<Visit> visitList = results.getResults();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void getTokenGoogle() throws UnirestException {
        System.out.println(Unirest.get("http://mathtap.de:1194/google-token/")
                .header("Authorization", "Token " + UserDataController.getToken())
                .asString().getBody());
    }

    @Ignore
    @Test
    public void updateVisit() throws UnirestException {

        Visit visit = new Visit("ChIJd_6tlTcGl0cRVpRkbna3w68", "test", new Date(), 15, "Sehr lecker");

        HttpResponse<JsonNode> response = Unirest.patch("http://mathtap.de:1194/visit/65/")
                .header("Authorization", "Token ff1827e43d61b8b6a0440511c777cb0ffb27d5c9")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(visit)
                .asJson();
        assertEquals(200, response.getStatus());
    }

    @Ignore
    @Test
    public void deleteVisit() throws UnirestException {
        //Visit erstellen und ID davon benutzen

        Visit visit = new Visit("ChIJd_6tlTcGl0cRVpRkbna3w68", "test", new Date(), 14, "Sehr lecker");

        HttpResponse<JsonNode> response1 = Unirest.post("http://mathtap.de:1194/visit/")
                .header("Authorization", "Token ff1827e43d61b8b6a0440511c777cb0ffb27d5c9")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(visit)
                .asJson();

        HttpResponse<VisitResults> response2 = Unirest.get("http://mathtap.de:1194/visit?username=test")
                .header("Authorization", "Token ff1827e43d61b8b6a0440511c777cb0ffb27d5c9")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .asObject(VisitResults.class);

        VisitResults results = response2.getBody();
        List<Visit> visitList = results.getResults();

        int size = visitList.size();
        Visit createdVisit = visitList.get(size-1);

        HttpResponse<String> response = Unirest.delete("http://mathtap.de:1194/visit/"+ createdVisit.getVisitId() +"/")
                .header("Authorization", "Token ff1827e43d61b8b6a0440511c777cb0ffb27d5c9")
                .header("Accept", "application/json")
                .asString();

        assertEquals(204, response.getStatus());

    }
}
