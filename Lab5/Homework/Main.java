package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Catalog catalog = new Catalog("MyDocuments");
        Document doc1 = new Document(0, "Book_1", "C:\\\\Users\\\\koroem\\\\Desktop\\\\book.txt", "BOOK");
        Document doc2 = new Document(1, "Paper_1", "C:\\\\Users\\\\koroem\\\\Desktop\\\\paper.txt", "PAPER");
        Document doc3 = new Document(2, "Article_1", "C:\\\\Users\\\\koroem\\\\Desktop\\\\article.txt", "ARTICLE");

        catalog.addDocument(doc1);
        catalog.addDocument(doc2);
        catalog.addDocument(doc3);

        String catalogFilePath = "catalog.json";
        catalog.save(catalogFilePath);


        Catalog newCatalog = new Catalog("NewCatalog");

        LoadCommand loadCommand = new LoadCommand(newCatalog, catalogFilePath);
        loadCommand.execute();


        ListCommand listCommand = new ListCommand(newCatalog);
        listCommand.execute();


        ViewCommand viewCommand = new ViewCommand(doc1);
        viewCommand.execute();


        String reportFilePath = "report.html";
        List<Document> documents = newCatalog.getDocuments();
        VelocityReportGenerator.generateReport(documents, reportFilePath);
        System.out.println("Report generated and saved to: " + reportFilePath);


        try {
            java.awt.Desktop.getDesktop().open(new File(reportFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
