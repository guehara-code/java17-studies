package dev.lpa;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Path.of("music_properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl(props.getProperty("url"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (var connection = dataSource.getConnection(
                props.getProperty("user"),
                System.getenv("MYSQL_PASS"))) {
            System.out.println("Success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
