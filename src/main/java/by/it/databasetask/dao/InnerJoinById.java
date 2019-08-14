package by.it.databasetask.dao;

import by.it.databasetask.pool.Connect;

import java.sql.*;

public class InnerJoinById {
    //language=SQL
    private static final String SQL_JOIN_USERS_ROLES = "SELECT * FROM accounts " +
            "INNER JOIN `roles` ON accounts.accesslevel=`roles`.`id`";
    //language=SQL

    private static final String SQL_COUNT_USERS = "SELECT COUNT(*) FROM accounts INNER JOIN `roles`" +
            " ON accounts.accesslevel=`roles`.`id`";
    private static final String SQL_COUNT_ROLES = "SELECT COUNT(*) FROM `roles` WHERE 1";
    private static final String STRING_COUNT_USERS = "Колличество пользователей: ";
    private static final String STRING_COUNT_ROLES = "Колличество ролей: ";

    public static void join() throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_JOIN_USERS_ROLES);
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int coummCount = metaData.getColumnCount();
                for (int i = 1; i < coummCount + 1; i++) {
                    System.out.print(metaData.getColumnLabel(i) + " = " +
                            resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        }
    }

    public static int findAllRows() throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_COUNT_USERS);
            if (resultSet.next()) {
                System.out.println(STRING_COUNT_USERS + resultSet.getInt(1));
                return resultSet.getInt(1);
            }
        }
        return 0;
    }

    public static int findRolesRows() throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_COUNT_ROLES);
            if (resultSet.next()) {
                System.out.println(STRING_COUNT_ROLES + resultSet.getInt(1));
                return resultSet.getInt(1);
            }
        }
        return 0;
    }
}