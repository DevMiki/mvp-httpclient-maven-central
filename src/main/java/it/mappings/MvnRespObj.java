package it.mappings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class MvnRespObj {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private Object responseHeader;
    private Object params;
    private Response response;

    public Object getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(Object responseHeader) {
        this.responseHeader = responseHeader;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "MvnRespObj{" +
                "responseHeader=" + responseHeader +
                ", params=" + params +
                ", response=" + response +
                '}';
    }
}
