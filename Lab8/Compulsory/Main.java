package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            ArtistDAO artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            artists.create("Led Zeppelin");
            artists.create("Queen");

            GenreDAO genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            genres.create("Hard Rock");

            Database.getConnection().commit();

            AlbumDAO albums = new AlbumDAO();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            albums.create(1982, "Thriller", "Michael Jackson", "Funk, Soul, Pop");
            albums.create(1971, "IV", "Led Zeppelin", "Hard Rock");
            albums.create(1975, "A Night at the Opera", "Queen", "Rock, Pop");

            Database.getConnection().commit();

            System.out.println("All albums in the database:");
            albums.printAllAlbums();

            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            try {
                Database.getConnection().rollback();
            } catch (SQLException rollbackException) {
                System.err.println(rollbackException);
            }
        }
    }
}
