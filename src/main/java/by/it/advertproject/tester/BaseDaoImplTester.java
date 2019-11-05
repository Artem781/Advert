package by.it.advertproject.tester;

import by.it.advertproject.bean.Account;
import by.it.advertproject.dao.impl.AccountDaoImpl;
import by.it.advertproject.dao.impl.BaseDaoImpl;
import by.it.advertproject.exception.DaoException;

import java.sql.*;
import java.util.List;

public class BaseDaoImplTester extends BaseDaoImpl<Account> {
//    //language=SQL
//    private static final String SQL_SELECT_ACCOUNT_BY_LOGIN =
//            "select anaron.account.idaccounts, anaron.account.name, anaron.account.login, anaron.account.password, " +
//                    "anaron.account.birthday, anaron.account.email, anaron.account.tel, anaron.account.accesslevel," +
//                    "anaron.account.photo from account where anaron.account.login = '?'";

    public static void main(String[] args) {


        try {
//            String url = "jdbc:mysql://localhost/store?serverTimezone=Europe/Moscow&useSSL=false";
            String url = "jdbc:mysql://localhost:3306/anaron?autoReconnect=true&characterEncoding=UTF-8&useUnicode=true&" +
                    "useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&" +
                    "serverSslCert=classpath";
            String username = "root";
            String password = "root";

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            System.out.println("register driver");

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                System.out.println("create Connection");


//                String sql = "INSERT INTO Products (ProductName, Price) Values (?, ?)";

//                language=SQL
                final String SQL_SELECT_ACCOUNT_BY_LOGIN =
                        "select anaron.account.idaccounts, anaron.account.name, anaron.account.login, anaron.account.password, " +
                                "anaron.account.birthday, anaron.account.email, anaron.account.tel, anaron.account.accesslevel," +
                                "anaron.account.photo from account where anaron.account.login = ?";
                final String SQL_SELECT_ACCOUNT_BY_LOGIN_FOR_STATEMENT =
                        "select anaron.account.idaccounts, anaron.account.name, anaron.account.login, anaron.account.password, " +
                                "anaron.account.birthday, anaron.account.email, anaron.account.tel, anaron.account.accesslevel," +
                                "anaron.account.photo from account where anaron.account.login = 'qwerty'";

//                Statement statement = conn.createStatement();
//                ResultSet resultSet = statement.executeQuery(SQL_SELECT_ACCOUNT_BY_LOGIN_FOR_STATEMENT);
//                while (resultSet.next()) {
//                    int id = resultSet.getInt(1);
//                    String name = resultSet.getString(2);
//                    String login = resultSet.getString(3);
//                    System.out.printf("%d. %s - %s \n", id, name, login);
//                }


                //language SQL
//                String sql = "INSERT INTO account (name, login) Values (?, ?)";
                String sql = "INSERT INTO account (name) Values (?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, "some");
                preparedStatement.executeUpdate();
//                preparedStatement.setInt(3, "artemLogin");

//                int rows = preparedStatement.executeUpdate();
//                System.out.printf("%d rows added", rows);

                System.out.println("ok");
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }


//        BaseDaoImplTester baseDaoImplTester = new BaseDaoImplTester();
//        try {
//            baseDaoImplTester.test();
//        } catch (DaoException e) {
//            System.out.println("Exception");
//        }
//
//        AccountDaoImpl accountDao = new AccountDaoImpl();
//        String pattern = "qwerty";
//        List<Account> accounts = findBy(SQL_SELECT_ACCOUNT_BY_LOGIN, "accounts", pattern);
    }

    void test() throws DaoException {
        AccountDaoImpl accountDao = new AccountDaoImpl();
        String pattern = "qwerty";
//        List<Account> accounts = findBy(SQL_SELECT_ACCOUNT_BY_LOGIN, "accounts", pattern);

    }

    @Override
    public List<Account> findAll() throws DaoException {
        return null;
    }

    @Override
    public Account findBeanById(long index) throws DaoException {
        return null;
    }

    @Override
    public void delete(Account account) throws DaoException {

    }

    @Override
    public Account create(Account account) throws DaoException {
        return null;
    }

    @Override
    public void update(Account account) throws DaoException {

    }
}
