package org.example;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Catalog {
    private List<Document> documents;
    private String name;

    public Catalog(String name) {
        this.name=name;
        this.documents = new ArrayList<>();
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public Document getDocument(Integer id) {
        return documents.get(id);
    }

    public void save(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(Catalog catalog,String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            catalog = objectMapper.readValue(new File(filePath), Catalog.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Catalog(" + name +
                ")"+
                "documents:" + documents;
    }

}
