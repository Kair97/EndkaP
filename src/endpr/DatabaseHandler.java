package endpr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
    private static DatabaseHandler dbhand;
    private Connection connection;

    private DatabaseHandler() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "kaireke");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to database", e);
        }
    }

    public static DatabaseHandler getDbhand() {
        if (dbhand == null) {
            dbhand = new DatabaseHandler();
        }
        return dbhand;
    }

    public Connection getConnection() {
        return connection;
    }
}
