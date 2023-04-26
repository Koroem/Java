package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumDAO {
    private Connection connection;
    private ArtistDAO artistDAO;
    private GenreDAO genreDAO;

    public AlbumDAO() {
        this.connection = Database.getConnection();
        this.artistDAO = new ArtistDAO();
        this.genreDAO = new GenreDAO();
    }

    public void create(int releaseYear, String title, String artistName, String genreNames) throws SQLException {
        Integer artistId = artistDAO.findByName(artistName);
        if (artistId == null) {
            throw new SQLException("Artist not found");
        }

        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO albums (release_year, title, artist_id) VALUES (?, ?, ?)")) {
            pstmt.setInt(1, releaseYear);
            pstmt.setString(2, title);
            pstmt.setInt(3, artistId);
            pstmt.executeUpdate();
        }

        // Assume that genres are separated by commas
        String[] genres = genreNames.split(",");
        for (String genreName : genres) {
            Integer genreId = genreDAO.findByName(genreName.trim());
            if (genreId == null) {
                throw new SQLException("Genre not found");
            }

            try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO album_genres (album_id, genre_id) VALUES (?, ?)")) {
                pstmt.setInt(1, artistId);
                pstmt.setInt(2, genreId);
                pstmt.executeUpdate();
            }
        }
    }
    public void printAllAlbums() {
        String sql = "SELECT a.id, a.release_year, a.title, ar.name as artist_name, g.name as genre_name " +
                "FROM albums a " +
                "JOIN artists ar ON a.artist_id = ar.id " +
                "JOIN album_genres ag ON a.id = ag.album_id " +
                "JOIN genres g ON ag.genre_id = g.id " +
                "ORDER BY a.id";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int releaseYear = rs.getInt("release_year");
                String title = rs.getString("title");
                String artistName = rs.getString("artist_name");
                String genreName = rs.getString("genre_name");
                System.out.println("ID: " + id + ", Release Year: " + releaseYear + ", Title: " + title +
                        ", Artist: " + artistName + ", Genre: " + genreName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}