package de.bestplaces.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by franzi on 08.06.2017.
 */
public class VisitResults {

    @JsonProperty(value="count")
    private int count;
    @JsonProperty(value="next")
    private String next;
    @JsonProperty(value="results")
    private List<Visit> results;
    @JsonProperty(value = "previous")
    private String previous;

    public VisitResults(){

    }

    public VisitResults(int count, String next, List<Visit> results, String previous) {
        this.count = count;
        this.next = next;
        this.results = results;
        this.previous = previous;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Visit> getResults() {
        return results;
    }

    public void setResults(List<Visit> results) {
        this.results = results;
    }
}
