package by.it.databasetask;

import java.sql.*;
import java.util.Properties;


public class Program {
    public static void main(String[] args) {

//  Регистрация дрпйвера необходима для веб приложений, для консольных приложений - нет.
//  Регистриция 2мя способами:

        //      1ый)      Class.forName("com.mysql.cj.jdbc.Driver");
        //      2ой)      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }


//MySQL 8
        String someString = "useJDBCCompliantTimezoneShift = true" +
                "useLegacyDatetimeCode = false" +
                "serverTimezone = UTC" +
                "serverSslCert = classpath:server.crt";

        String dbUser = "root";
        String dbPassword = "root";
        String dbUrl1 = "jdbc:mysql://localhost:3306/anaron";
        String dbUrl = "jdbc:mysql://localhost:3306/" +
                "?useUnicode=true" +
                "&characterEncoding=UTF-8" +
                "&verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "root");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        properties.put("useSSL", "true");
        properties.put("useJDBCCompliantTimezoneShift", "true");
        properties.put("useLegacyDatetimeCode", "false");
        properties.put("serverTimezone", "UTC");
        properties.put("serverSslCert", "classpath:server.crt");
//        try (Connection connection = DriverManager.getConnection(dbUrl1, properties);
//        try (Connection connection = DriverManager.getConnection(dbUrl1, properties);
        try (Connection connection = DriverManager.getConnection(dbUrl1, "root", "root");
             Statement statement = connection.createStatement()) {
            System.out.println("connection is OK-----------------------------");
//            @Language ("SQL")
            //language=SQL
            String requestSql = "select * from advert";
            boolean execute = statement.execute(requestSql);
            System.out.println(execute);


//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from fix_user");
//while (resultSet.next()){
//    System.out.println(resultSet.getString("name"));
//}
        } catch (SQLException e) {
            System.out.println("connection is not ===========\n" + e);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        }


    }
}
