package dev.lpa;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;


public class Main {

    private final static String CONN_STRING = "jdbc:mariadb://localhost:3306/music";

//    ("jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword");

    public static void main(String[] args) {

        String username = JOptionPane.showInputDialog(
                null, "Enter DB Username");

        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf,
                "Enter DB Password", JOptionPane.OK_CANCEL_OPTION);
        final char[] password =
                (okCxl == JOptionPane.OK_OPTION) ? pf.getPassword() : null;

        var dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl(CONN_STRING);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        try (Connection connection = DriverManager.getConnection(
//                CONN_STRING, username, String.valueOf(password))) {
        try (Connection connection = dataSource.getConnection(username, String.valueOf(password))) {
            System.out.println("Success!! Connection made to the music database");
            Arrays.fill(password, ' ');
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
