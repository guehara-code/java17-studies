package dev.lpa;

import java.sql.*;

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
//            String artist = "Neil Young";
//            String query = "SELECT * FROM artists WHERE artist_name='%s'".formatted(artist);
//            boolean result = statement.execute(query);
//            System.out.println("result = " + result);
//            var rs = statement.getResultSet();
//            boolean found = (rs != null && rs.next());
//            System.out.println("Artist was " + (found ? "found" : "not found"));

            String tableName = "music.artists";
            String columnName = "artist_name";
            String columnValue = "Elf";
            if (!executeSelect(statement,tableName, columnName, columnValue)) {
                System.out.println("Maybe we should add this record");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean printRecords(ResultSet resultSet) throws SQLException {

        boolean foundData = false;
        var meta = resultSet.getMetaData();

        System.out.println("=============================");

        for (int i = 1; i <= meta.getColumnCount(); i++) {
            System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
        }
        System.out.println();

        while (resultSet.next()) {
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.printf("%-15s", resultSet.getString(i));
            }
            System.out.println();
            foundData = true;
        }

        return foundData;
    }

    private static boolean executeSelect(Statement statement, String table,
                                         String columnName, String columnValue) throws SQLException {
        String query = "SELECT * FROM %s WHERE %s='%s'".formatted(table, columnName, columnValue);
        var rs = statement.executeQuery(query);
        if (rs != null) {
            return printRecords(rs);
        }
        return false;
    }
}
