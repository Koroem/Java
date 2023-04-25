package org.example;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Catalog {
    private List<Document> documents;
    private String name;
    public Catalog() {}
    public Catalog(String name) {
        this.name=name;
        this.documents = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void addDocument(Document document) {
        documents.add(document);
    }


    public void save(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Catalog loadedCatalog = objectMapper.readValue(new File(filePath), Catalog.class);
            this.documents = loadedCatalog.documents;
            this.name = loadedCatalog.name;
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