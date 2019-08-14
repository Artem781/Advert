//package by.it.databasetask.dao;
//
//import by.it.advertproject.bean.Account;
//import by.it.databasetask.pool.Connect;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//public class UserDao implements InterfaceDao<Account> {
//
//    public boolean create(Account account) throws SQLException {
//        String sqlCmd = String.format(Locale.ENGLISH,
//                "INSERT INTO `users` " +
//                        "(`name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) " +
//                        "VALUES ('%s','%s','%s','%s','%s','%s','%d')",
//                account.getName(), account.getLogin(), account.getPassword(), account.getBirthday(), account.getEmail(),
//                account.getTel(), account.getRole());
//        long id = Dao.executeCreateAndGetId(sqlCmd);
//        account.setId(id);
//        return id > 0;
//    }
//
//    public Account read(long id) throws SQLException {
//        String sqlSuffix = String.format(Locale.ENGLISH,
//                " WHERE id=%d", id);
//        List<Account> all = getAll(sqlSuffix);
//        return all.size() > 0 ? all.get(0) : null;
//    }
//
//    public boolean update(Account account) throws SQLException {
//        String sqlCmd = String.format(
//                "UPDATE `users` SET " +
//                        "`name`='%s'," +
//                        "`login`='%s'," +
//                        "`password`='%s'," +
//                        "`dateofbirth`='%s'," +
//                        "`email`='%s'," +
//                        "`tel`='%s'," +
//                        "`roles_id`='%d' " +
//                        "WHERE `users`.`id`=%d",
//                account.getName(), account.getLogin(), account.getPassword(),
//                account.getBirthday(), account.getEmail(), account.getTel(),
//                account.getRole(), account.getId()
//        );
//        return Dao.executeUpdate(sqlCmd);
//    }
//
//    public boolean delete(Account account) throws SQLException {
//        String sqlCmd = String.format(Locale.ENGLISH,
//                "DELETE FROM `users` WHERE `users`.`id`=%d", account.getId());
//        return Dao.executeUpdate(sqlCmd);
//    }
//
//    @Override
//    public List<Account> getAll(String sqlSuffix) throws SQLException {
//        List<Account> result = new ArrayList<>();
//        String sqlCmd = String.format(Locale.ENGLISH,
//                "SELECT * " +
//                "FROM `users` %s", sqlSuffix);
//        try (Connection connection = Connect.getConnection();
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(sqlCmd);
//            while (resultSet.next()) {
//                long id = resultSet.getLong("id");
//                String name = resultSet.getString("name");
//                String login = resultSet.getString("login");
//                String password = resultSet.getString("password");
//                String dateofbirth = resultSet.getString("dateofbirth");
//                String email = resultSet.getString("email");
//                String tel = resultSet.getString("tel");
//                long roles_id = resultSet.getLong("roles_id");
////                Account account = new Account( name, login, password, dateofbirth, email, tel, roles_id);
////                result.add(account);
//            }
////            return result;
//            return null;
//        }
//    }
//}
