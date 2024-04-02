package dev.lpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MusicDML {

    public static void main(String[] args) {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/music",
                System.getenv("MYSQL_USER"),
                System.getenv("MYSQL_PASS"));
             Statement statement = connection.createStatement();
        ) {
            String artist = "Elf";
            String query = "SELECT * FROM artists WHERE artist_name='%s'".formatted(artist);
            boolean result = statement.execute(query);
            System.out.println("result = " + result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
