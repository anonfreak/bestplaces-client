package de.bestplaces;

import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.controller.PlaceController;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;


/**
 * Created by franz on 08.05.2017.
 */
public class testPlaceController {

    private PlaceController placeController;

    @Before
    public void setUp() {
        placeController = new PlaceController();
    }

    @Test
    public void testSearch() throws UnirestException {
        assertNotNull(placeController.getFullPlaceInformationToPlaceWithId("ChIJd_6tlTcGl0cRVpRkbna3w68", null));
    }

}
