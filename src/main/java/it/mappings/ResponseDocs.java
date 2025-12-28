package it.mappings;

public class ResponseDocs {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ResponseDocs{" +
                "id='" + id + '\'' +
                '}';
    }
}
