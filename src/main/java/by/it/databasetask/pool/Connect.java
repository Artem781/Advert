package by.it.databasetask.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Connect {
    private static volatile Connection connection;
//     final static  String URL = "jdbc:mysql://localhost:3306" +
//            "?useUnicode=true" +
//            "&characterEncoding=UTF-8" +
//            "&verifyServerCertificate=false" +
//            "&useSSL=false" +
//            "&requireSSL=false" +
//            "&useLegacyDatetimeCode=false" +
//            "&amp" +
//            "&serverTimezone=UTC";
//    final static String SIGN_IN = "root";
//    final static String PASSWORD = "root";

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("anaron", Locale.ENGLISH);
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        if (connection == null || connection.isClosed()) {
            synchronized (Connect.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(url, user, pass);
                }
            }
        }
        return connection;

    }
}
