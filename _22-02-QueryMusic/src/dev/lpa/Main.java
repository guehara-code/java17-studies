package dev.lpa;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Path.of("music_properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        String query = "SELECT * FROM music.artists";

        var dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl(props.getProperty("url"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter an Album Name: ");
//        String albumName = scanner.nextLine();
////        String albumName = "Tapestry";
//        String query = "SELECT * FROM music.albumview WHERE album_name='%s'".formatted(albumName);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter an Artist Id: ");
//        String artistId = scanner.nextLine();
//        int artistid = Integer.parseInt(artistId);

//        String query = "SELECT * FROM music.artists WHERE artist_id=%d".formatted(artistid);
        String query = "SELECT * FROM music.artists limit 10";
//        String query = """
//                WITH RankedRows AS (
//                                        SELECT *,
//                                        ROW_NUMBER() OVER (ORDER BY artist_id) AS row_num
//                                        FROM music.artists
//                                    )
//                                    SELECT *
//                                        FROM RankedRows
//                                        WHERE row_num <= 10""";

        try (var connection = dataSource.getConnection(
                props.getProperty("user"),
                System.getenv("MYSQL_PASS"));
             Statement statement = connection.createStatement();
        ) {
//            System.out.println("Success!");
            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                System.out.printf("%d %s %n", resultSet.getInt(1),
//                        resultSet.getString("artist_name"));
//            }

            var meta = resultSet.getMetaData();
//            for (int i = 1; i <= meta.getColumnCount(); i++) {
//                System.out.printf("%d %s %s%n", i, meta.getColumnName(i), meta.getColumnTypeName(i));
//            }
            System.out.println("=============================");

            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
            }
            System.out.println();

            while (resultSet.next()) {
//                System.out.printf("%d %s %s %n", resultSet.getInt("track_number"),
//                        resultSet.getString("artist_name"),
//                        resultSet.getString("song_title"));
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.printf("%-15s", resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
