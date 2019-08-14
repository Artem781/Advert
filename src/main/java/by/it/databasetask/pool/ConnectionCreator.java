package by.it.databasetask.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionCreator {
    static {
        // registter driver
    }
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(
            "prop\\database.propertties");
    private static String url = resourceBundle.getString("db.url");
    private static String user = resourceBundle.getString("db.user");
    private static String password = resourceBundle.getString("db.password");

    static Connection createConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }






}

