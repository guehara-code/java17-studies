package dev.lpa;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Challenge2 {

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

            String alterString =
                  "ALTER TABLE storefront.order_details ADD COLUMN quantity INT";
            Statement statement = conn.createStatement();
            statement.execute(alterString);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
