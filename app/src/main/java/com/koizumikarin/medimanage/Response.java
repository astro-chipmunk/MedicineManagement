package com.koizumikarin.medimanage;

import java.util.List;

public class Response {
    private static final String TAG = Response.class.getSimpleName();
    private final Response self = this;

    private List<Result> results;

    public Response(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}