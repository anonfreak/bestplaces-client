package de.bestplaces;

import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.controller.VisitController;
import de.bestplaces.model.Visit;
import org.junit.*;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by franzi on 26.05.2017.
 */
public class TestVisitController {

    private VisitController visitController;

    @Before
    public void setUp() {
        visitController = new VisitController();
    }

    @Test
    public void testAddVisitToTimeline() throws UnirestException {

        Date date = new Date();
        date.setTime(1495742164);
        Visit testVisit = new Visit("ChIJd_6tlTcGl0cRVpRkbna3w68", "Franzi", date, 10, "Sehr lecker");

        assertEquals(true, visitController.addVisitToTimeline(testVisit));
    }

}
