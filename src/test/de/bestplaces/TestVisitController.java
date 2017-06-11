package de.bestplaces;

import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.controller.UserDataController;
import de.bestplaces.controller.VisitController;
import de.bestplaces.model.Visit;
import org.junit.*;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by franzi on 26.05.2017.
 */
public class TestVisitController extends AbstractRestTest {

    private VisitController visitController;
    private Visit testVisit;

    @Before
    public void setUp() throws UnirestException {
        super.setUp();
        visitController = new VisitController();
        System.out.println(UserDataController.getToken());
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
        assertNotNull(visitController.getVisits());
    }

    @Test
    public void editVisit() throws UnirestException {
        List<Visit> visits = visitController.getVisits();
        Visit testVisit = visits.get(0);
        testVisit.setMoney(120.0);
        assertEquals(120.0, visitController.updateVisit(testVisit).getMoney(), 1);
    }

}
