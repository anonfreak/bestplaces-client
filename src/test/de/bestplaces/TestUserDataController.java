package de.bestplaces;

import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.controller.UserDataController;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runners.MethodSorters;


/**
 * Created by franz on 30.04.2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserDataController {

    private static UserDataController userDataController;

    @BeforeClass
    public static void init()
    {
        userDataController = new UserDataController();
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

    @AfterClass
    public static void removeUser() throws UnirestException {
        //diese Methode ist noch leer im Controller
        assertEquals(true, userDataController.removeUser("IskaN"));
    }
}
