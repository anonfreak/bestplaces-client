package de.bestplaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.model.Place;
import de.bestplaces.model.User;
import de.bestplaces.model.Visit;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by franz on 02.12.2016.
 */
public class testRestAPI {

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

    @Ignore
    @Test
    public void search() throws UnirestException {
        HttpResponse<Place[]> response = Unirest.get("http://mathtap.de:1194/place/search?q=" + "Pizza" + "&location=" + "Karlsruhe")
            .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .asObject(Place[].class);

        assertEquals(200, response.getStatus());
    }


    @Test
    public void addVisitToTimelineTest() throws UnirestException {

        Date date = new Date();
        date.setTime(1495742164);
        Visit testVisit = new Visit("ChIJd_6tlTcGl0cRVpRkbna3w68", "Franzi", date, 10, "Sehr lecker");

        HttpResponse<JsonNode> response = Unirest.post("http://mathtap.de:1194/visit/")
                .header("Authorization", "Token 80f8d09d703f70f7a30c5ecba4428f6376c16d6d")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(testVisit)
                .asJson();
        assertEquals(201, response.getStatus());
    }
}
