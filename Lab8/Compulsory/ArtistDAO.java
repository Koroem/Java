package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistDAO {
    private Connection connection;

    public ArtistDAO() {
        this.connection = Database.getConnection();
    }

    public void create(String name) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO artists (name) VALUES (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT id FROM artists WHERE name = ?")) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getInt(1) : null;
        }
    }
}

