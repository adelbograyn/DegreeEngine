package org.softwareengine.utils.services;

import org.sqlite.SQLiteConfig;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DatabaseService {
    public static Connection connection;

    public static void openConnection() throws SQLException {
        SQLiteConfig sqLiteConfig = new SQLiteConfig();
        sqLiteConfig.enforceForeignKeys(true);
        sqLiteConfig.setEncoding(SQLiteConfig.Encoding.UTF8);

//        connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\resources\\databases\\casher-engine.db");
//        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/databases/degree-engine.db");
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + Objects.requireNonNull(
                    DatabaseService.class.getResource("/databases/degree-engine.db")).toURI(), sqLiteConfig.toProperties()
            );
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() throws SQLException {
        if (!connection.isClosed()) connection.close();
    }
}
