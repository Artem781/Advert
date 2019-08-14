package by.it.advertproject.tester;

import by.it.advertproject.connectionpool.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PoolTester {
    public static void main(String[] args) {
        Connection connection = ConnectionPool.INSTANCE.takeConnection();
        try {
            System.out.println(connection.isClosed());
        } catch (SQLException e) {
            System.out.println("____________________connection.isClosed()\n");
        }
        try {
            Statement statement = connection.createStatement();
            boolean execute = statement.execute("select * from advert");
            System.out.println(execute);
        } catch (SQLException e) {
            System.out.println("____________________createStatement()\n");
        }
        ConnectionPool.INSTANCE.destroyPool();
        ConnectionPool.INSTANCE.dispose();
//

//        String driver = "com.mysql.cj.jdbc.Driver";
//        String user = "root";
//        String psw = "root";
//        String url = "jdbc:mysql://localhost:3306/anaron?"+
//                "autoReconnect=true&characterEncoding=UTF-8&useUnicode=true&"+
//                "useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"+
//                "serverTimezone=UTC&serverSslCert=classpath";
//
//
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            System.out.println("-_______________________-driver");
//        }
//        try {
//            DriverManager.getConnection(url, "root", "root");
//            System.out.println("++++++++++++++++++++++++  YES Connection");
//        } catch (SQLException e) {
//            System.out.println("_____________________Not connection");        }

    }
}
