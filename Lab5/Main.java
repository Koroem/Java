package org.example;

public class Main {
    public static void main(String args[]) {

        Catalog catalog =
                new Catalog("MyDocuments");
        Document doc1 = new Document(0,"Random_Book_1","path",DocumentType.BOOK);
        Document doc2 = new Document(0,"Random_Paper_1","path",DocumentType.PAPER);
        Document doc3 = new Document(0,"Random_Article_1","path",DocumentType.ARTICLE);
        catalog.addDocument(doc1);
        catalog.addDocument(doc2);
        catalog.addDocument(doc3);

        System.out.print(catalog.toString());
        catalog.save("C:\\Users\\Koroem\\Desktop");
    }
}