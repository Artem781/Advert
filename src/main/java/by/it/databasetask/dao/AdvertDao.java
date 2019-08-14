//package by.it.databasetask.dao;
//
//import by.it.advertproject.bean.Advert;
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
//public class AdvertDao implements InterfaceDao<Advert> {
//    public boolean create(Advert advert) throws SQLException {
//        String sqlCmd = String.format(Locale.ENGLISH,
//                "INSERT INTO `ads` " +
//                        "(`title`," +
//                        "`description`, " +
//                        "`brand`," +
//                        "`model`," +
//                        "`color`," +
//                        "`body`," +
//                        "`year`," +
//                        "`engine`," +
//                        "`at`," +
//                        "`driveunit`," +
//                        "`equipment`," +
//                        "`mileage`," +
//                        "`crashed`," +
//                        "`price`," +
//                        "`users_id`) " +
//                        " VALUES ('%s','%s','%s','%s','%s','%s','%d','%f','%s','%s','%s','%d','%s','%f','%d')",
//                advert.getTitle(), advert.getDescription(), advert.getBrand(), advert.getModel(), advert.getColor(), advert.getBody(),
//                advert.getYear(), advert.getEngine(), advert.getAt(), advert.getDriveunit(), advert.getEquipment(),
//                advert.getMilage(), advert.getCrashed(), advert.getPrice(), advert.getAccountIdFk());
//        long id = Dao.executeCreateAndGetId(sqlCmd);
//        advert.setId(id);
//        return id > 0;
//    }
//
//    public Advert read(long id) throws SQLException {
//        String sqlSuffix = String.format(Locale.ENGLISH,
//                " WHERE id=%d", id);
//        List<Advert> all = getAll(sqlSuffix);
//        return all.size() > 0 ? all.get(0) : null;
//    }
//
//    public boolean update(Advert advert) throws SQLException {
//        String sqlCmd = String.format(Locale.ENGLISH,
//                "UPDATE `ads` SET " +
//                        "`title`='%s'," +
//                        "`description`='%s'," +
//                        "`brand`='%s'," +
//                        "`model`='%s'," +
//                        "`color`='%s'," +
//                        "`body`='%s'," +
//                        "`year`='%d'," +
//                        "`engine`='%f'," +
//                        "`at`='%s'," +
//                        "`driveunit`='%s'," +
//                        "`equipment`='%s'," +
//                        "`mileage`='%d'," +
//                        "`crashed`='%s'," +
//                        "`price`='%f'," +
//                        "`users_id`='%d' " +
//                        "WHERE `ads`.`id`=%d",
//                advert.getTitle(), advert.getDescription(), advert.getBrand(), advert.getModel(),
//                advert.getColor(), advert.getBody(), advert.getYear(), advert.getEngine(), advert.getAt(), advert.getDriveunit(),
//                advert.getEquipment(), advert.getMilage(), advert.getCrashed(), advert.getPrice(), advert.getAccountIdFk(), advert.getId()
//        );
//        return Dao.executeUpdate(sqlCmd);
//    }
//
//    public boolean delete(Advert advert) throws SQLException {
//        String sqlCmd = String.format(Locale.ENGLISH,
//                "DELETE FROM `ads` WHERE `ads`.`id`=%d", advert.getId());
//        return Dao.executeUpdate(sqlCmd);
//    }
//
//
//    public static List<Advert> searchAd(String searchWord) throws SQLException {
//        List<Advert> searchResult = new ArrayList<>();
//        String sqlCmd = String.format("SELECT * FROM ads WHERE MATCH (brand) AGAINST ('%s')", searchWord);
//        try (Connection connection = Connect.getConnection();
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(sqlCmd);
//            while (resultSet.next()) {
//                long id = resultSet.getLong("id");
//                String title = resultSet.getString("title");
//                String description = resultSet.getString("description");
//                String brand = resultSet.getString("brand");
//                String model = resultSet.getString("model");
//                String color = resultSet.getString("color");
//                String body = resultSet.getString("body");
//                int year = resultSet.getInt("year");
//                double engine = resultSet.getDouble("engine");
//                String at = resultSet.getString("at");
//                String driveunit = resultSet.getString("driveunit");
//                String equipment = resultSet.getString("equipment");
//                int mileage = resultSet.getInt("mileage");
//                String crashed = resultSet.getString("crashed");
//                int price = resultSet.getInt("price");
//                long users_id = resultSet.getLong("users_id");
//                Advert advert = new Advert( title, description, brand, model, color, body, year, engine, at, driveunit, equipment, mileage, crashed, price, users_id);
//                searchResult.add(advert);
//            }
//            return searchResult;
//        }
//    }
//
//    public List<Advert> getAll(String sqlSuffix) throws SQLException {
//        List<Advert> result = new ArrayList<>();
//        String sqlCmd = String.format(Locale.ENGLISH,
//                "SELECT * " +
//                        "FROM `ads` %s", sqlSuffix);
//        try (Connection connection = Connect.getConnection();
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(sqlCmd);
//            while (resultSet.next()) {
//                long id = resultSet.getLong("id");
//                String title = resultSet.getString("title");
//                String description = resultSet.getString("description");
//                String brand = resultSet.getString("brand");
//                String model = resultSet.getString("model");
//                String color = resultSet.getString("color");
//                String body = resultSet.getString("body");
//                int year = resultSet.getInt("year");
//                double engine = resultSet.getDouble("engine");
//                String at = resultSet.getString("at");
//                String driveunit = resultSet.getString("driveunit");
//                String equipment = resultSet.getString("equipment");
//                int mileage = resultSet.getInt("mileage");
//                String crashed = resultSet.getString("crashed");
//                int price = resultSet.getInt("price");
//                long users_id = resultSet.getLong("users_id");
//                Advert advert = new Advert( title, description, brand, model, color, body, year, engine, at, driveunit, equipment, mileage, crashed, price, users_id);
//                result.add(advert);
//            }
//            return result;
//        }
//    }
//}
