package de.bestplaces.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.model.Address;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Geo;
import de.bestplaces.model.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


    public void addPlace()
    {

    }

    public void updatePlaceInformation()
    {

    }

    public FullPlace getFullPlaceInformationToPlaceWithId(String placeId, String userId) throws UnirestException {

        //Request mit id
        //HttpResponse<FullPlace> response = Unirest.get("http://mathtap.de:1194/place/" + placeId + "?userId=" + userId)
        //        .header("Authorization", "Token " + getToken())
        //        .header("Accept", "application/json")
        //        .header("Content-Type", "application/json")
        //        .asObject(FullPlace.class);

        //FullPlace place = response.getBody();

        Geo geo = new Geo();
        List<String> pictures = new ArrayList<>();
        pictures.add("https://s3-media2.fl.yelpcdn.com/bphoto/FK66TQEFCj4jtQSsP590vw/ls.jpg");
        pictures.add("https://www.karlsruhe-insider.de/wp-content/uploads/2015/09/Eismarie1.jpg");
        List<String> categories = new ArrayList<>();
        categories.add("Food");
        categories.add("Pizza");
        Address address = new Address("Karlstraße", 178, "karlsruhe", 76137);

        List<String> openingHours = new ArrayList<>();
        openingHours.add("Monday-Friday: 9:00 - 20:00");
        openingHours.add("Saturday: 9:00 - 23:00");
        openingHours.add("Sunday: geschlossen");
        Review review = new Review(5, true, "Yummiy, einfach köstlich");

            FullPlace place = new FullPlace("ChIJd_6tlTcGl0cRVpRkbna3w68", "PizzaBlitz", geo, "Blablablastraße",true, 5,
                pictures, categories, address, "0721/826110", "http://tollsteWebsite.com", openingHours, false, review);

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
