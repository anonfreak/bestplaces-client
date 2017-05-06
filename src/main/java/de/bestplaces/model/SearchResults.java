package de.bestplaces.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import cucumber.api.java.eo.Se;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kolbm on 06.05.2017.
 */
public class SearchResults {
    @JsonProperty(value="pagetoken")
    private String pagetoken;
    @JsonProperty(value="results")
    private List<Place> results;

    public SearchResults(){
        pagetoken = "";
        results = new ArrayList<>();
    }

    public SearchResults(String pagetoken, List<Place> results) {
        this.pagetoken = pagetoken;
        this.results = results;
    }

    public String getPagetoken() {
        return pagetoken;
    }

    public void setPagetoken(String pagetoken) {
        this.pagetoken = pagetoken;
    }

    public List<Place> getResults() {
        return results;
    }

    public void setResults(List<Place> results) {
        this.results = results;
    }
}
