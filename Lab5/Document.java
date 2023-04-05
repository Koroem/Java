package org.example;


import java.util.HashMap;
import java.util.Map;

public class Document {
    private Integer id;

    private DocumentType type;

    private String name;
    private String location;
    private Map<DocumentType, String> tags;

    public Document(Integer id, String name, String location,DocumentType type) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type=type;
        this.tags = new HashMap<>();
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

    public void addTag(DocumentType key, String value) {
        tags.put(key, value);
    }

    public String getTag(DocumentType key) {
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
}
