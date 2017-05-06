package de.bestplaces;

import com.mashape.unirest.http.exceptions.UnirestException;
import de.bestplaces.controller.SearchController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kolbm on 06.05.2017.
 */
public class TestSearchController {
    private SearchController searchController;

    @Before
    public void setUp() {
        searchController = new SearchController();
    }

    @Test
    public void testSearch() throws UnirestException {
        assertNotNull(searchController.search("Pizza", "Karlsruhe"));
    }
}
