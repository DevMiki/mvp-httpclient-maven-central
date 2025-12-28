package it.mappings;

import java.util.List;

public class Response {

    private int numFound;
    private int start;
    private List<ResponseDocs> docs;

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<ResponseDocs> getDocs() {
        return docs;
    }

    public void setDocs(List<ResponseDocs> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "Response{" +
                "numFound=" + numFound +
                ", start=" + start +
                ", docs=" + docs +
                '}';
    }
}
