package dev.lpa;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static String USE_SCHEMA = "USE storefront";

    public static void main(String[] args) {

        var dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/");
            dataSource.setUser(System.getenv("MariaDBUSER"));
            dataSource.setPassword(System.getenv("MariaDBPASS"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Connection conn = dataSource.getConnection()) {

            if (!checkSchema(conn)) {
                System.out.println("storefront schema does not exist");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean checkSchema(Connection conn) {

        try (Statement statement = conn.createStatement()) {
            statement.execute(USE_SCHEMA);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
