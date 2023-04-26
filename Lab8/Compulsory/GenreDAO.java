package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreDAO {
    private Connection connection;

    public GenreDAO() {
        this.connection = Database.getConnection();
    }

    public void create(String name) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO genres (name) VALUES (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT id FROM genres WHERE name = ?")) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getInt(1) : null;
        }
    }
}
