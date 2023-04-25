package org.example;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {
    private int id;
    private String name;
    private String type;
    private String location;
    private Map<String, String> tags = new HashMap<>();

    /* cand dam load la un document */
    @JsonCreator
    public Document(@JsonProperty("id") int id,
                    @JsonProperty("name") String name,
                    @JsonProperty("location") String location,
                    @JsonProperty("type") String type) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void addTag(String key, String value) {
        tags.put(key, value);
    }

    public String getTag(String key) {
        return tags.get(key);
    }

    @Override
    public String toString() {
        return "Document:" +
                id + '\'' +
                ", type:'"+ type +
                ", name:'" + name +
                ", location:'" + location +
                ", tags:" + tags;
    }
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
