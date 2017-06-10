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
    private Visit testVisit;

    @Before
    public void setUp() {
        visitController = new VisitController();
        Date date = new Date();
        date.setTime(1495742164);
        testVisit = new Visit("ChIJd_6tlTcGl0cRVpRkbna3w68", "test", date, 13, "Sehr lecker");
    }

    @Test
    public void testAddVisitToTimeline() throws UnirestException {
        assertEquals(true, visitController.addVisitToTimeline(testVisit));
    }

    @Test
    public void testGetVisits() throws UnirestException {
        assertNotNull(visitController.getVisits("test"));
    }

    @Ignore
    @Test
    public void editVisit() throws UnirestException {
        testVisit.setMoney(15);
        assertEquals(true, visitController.updateVisit(testVisit));
    }

}
