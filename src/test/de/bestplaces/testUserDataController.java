package de.bestplaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.ca.I;
import de.bestplaces.controller.UserDataController;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.IOException;

/**
 * Created by franz on 30.04.2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testUserDataController {

    UserDataController userDataController;

    @Before
    public void init()
    {
        userDataController = new UserDataController();
    }

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

    @Test
    public void testACreateUser() throws UnirestException {

        assertEquals(true, userDataController.createUser("IskaN","Franziska",
                "Neumann", "shaundasschaf.neumann@gmx.de", "1234", "Karlsruhe"));
    }

    @Test
    public void testBLogin() throws UnirestException {
        assertEquals(true, userDataController.login("IskaN", "1234"));
    }

    @Test
    public void testCGetUserData() throws UnirestException {
        assertEquals("IskaN", userDataController.getUserData().getUsername());
    }

    @Test
    public void testDEditUserData() throws UnirestException {
        assertEquals(true, userDataController.editUserData("Franziska", "Neumann",
                "Durlach", "shaundasschaf.neumann@gmx.de", "1234"));
    }

    @After
    public void removeUser()
    {
        //diese Methode ist noch leer im Controller
        userDataController.removeUser();
    }
}
