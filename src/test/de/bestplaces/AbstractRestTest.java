package de.bestplaces;

import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.controller.UserDataController;
import org.junit.Before;
import org.junit.Ignore;

/**
 * Created by kolbm on 11.06.2017.
 */
public class AbstractRestTest {
    public void setUp() throws UnirestException{
        UserDataController.login("test", "test");
    }
}
