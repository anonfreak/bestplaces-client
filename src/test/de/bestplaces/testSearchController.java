package de.bestplaces;

import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.controller.SearchController;
import org.junit.*;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by franz on 06.05.2017.
 */
public class testSearchController {

    private  SearchController searchController;

    @Before
    public void setUp() {
        searchController = new SearchController();
    }

    @Test
    public void testSearch() throws UnirestException {
        assertNotNull(searchController.search("Pizza", "Karlsruhe"));
    }

    @Test
    public void loadMorePlaces() throws UnirestException {
        assertNotNull(searchController.searchMore("Pizza"));
    }

}

