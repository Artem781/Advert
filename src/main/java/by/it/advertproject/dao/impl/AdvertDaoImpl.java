package by.it.advertproject.dao.impl;

import by.it.advertproject.bean.Advert;
import by.it.advertproject.connectionpool.ConnectionPool;
import by.it.advertproject.dao.AdvertDao;
import by.it.advertproject.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static by.it.advertproject.command.Message.INTERNAL_ERROR;

public class AdvertDaoImpl extends BaseDaoImpl<Advert> implements AdvertDao {
    private static final Logger logger = LogManager.getLogger(AdvertDaoImpl.class);
    static final String TABLE_NAME = "advert";
    //language=SQL
    private static final String SQL_SELECT_ADVERT_BY_ID =
            "SELECT anaron.advert.idadvert, anaron.advert.title, anaron.advert.description," +
                    " anaron.advert.brand, anaron.advert.model, anaron.advert.color, " +
                    "anaron.advert.body, anaron.advert.year, anaron.advert.engine, anaron.advert.at," +
                    " anaron.advert.driveunit, anaron.advert.equipment, anaron.advert.mileage, " +
                    "anaron.advert.crashed, anaron.advert.price, anaron.advert.accountidfk " +
                    "FROM anaron.advert WHERE anaron.advert.idadvert = ?";
    //language=SQL
    private static final String SQL_UPDATE_ADVERT =
            "UPDATE anaron.advert SET advert.title = ?, advert.description = ?," +
                    " advert.brand = ?, advert.model = ?, advert.color = ?, " +
                    "advert.body = ?, advert.year = ?, advert.engine = ?," +
                    " advert.at = ?, advert.driveunit = ?, advert.equipment = ?," +
                    " advert.mileage = ?, advert.crashed = ?, advert.price = ?," +
                    " advert.accountidfk = ? WHERE anaron.account.idaccounts = ?";
    //language=SQL
    private static final String SQL_DELETE_ADVERT =
            "DELETE FROM anaron.advert WHERE advert.idadvert = ?";
    //language=SQL
    private static final String SQL_CREATE_ADVERT =
            "INSERT INTO anaron.advert " +
                    "(title, description, brand, model, color, body, year," +
                    " engine, at, driveunit, equipment, mileage, crashed, " +
                    "price, accountidfk)" +
                    " Values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //language=SQL
    private static final String SQL_SELECT_ADVERT_BY_TITLE =
            "SELECT anaron.advert.idadvert, anaron.advert.title, anaron.advert.description," +
                    " anaron.advert.brand, anaron.advert.model, anaron.advert.color, " +
                    "anaron.advert.body, anaron.advert.year, anaron.advert.engine," +
                    " anaron.advert.at, anaron.advert.driveunit, anaron.advert.equipment, " +
                    "anaron.advert.mileage, anaron.advert.crashed, anaron.advert.price," +
                    " anaron.advert.accountidfk FROM anaron.advert WHERE anaron.advert.title = ?";
    //language=SQL
    private static final String SQL_SELECT_ADVERT_BY_ACCOUNT_ID_FK =
            "SELECT advert.idadvert, advert.title, advert.description," +
                    " advert.brand, advert.model, advert.color, " +
                    "advert.body, advert.year, advert.engine," +
                    " advert.at, advert.driveunit, advert.equipment, " +
                    "advert.mileage, advert.crashed, advert.price," +
                    " advert.accountidfk FROM advert WHERE advert.accountidfk = ?";
    //language=SQL
    private static final String SQL_SELECT_ALL_ADVERTS =
            "SELECT anaron.advert.idadvert, anaron.advert.title, anaron.advert.description," +
                    "anaron.advert.brand, anaron.advert.model, anaron.advert.color," +
                    "anaron.advert.body, anaron.advert.year, anaron.advert.engine, anaron.advert.at," +
                    "anaron.advert.driveunit, anaron.advert.equipment, anaron.advert.mileage," +
                    "anaron.advert.crashed, anaron.advert.price, anaron.advert.accountidfk " +
                    " FROM anaron.advert";

    @Override
    public List<Advert> findAdvertByTitle(String patternTitle) throws DaoException {
        List<Advert> entities = findBy(SQL_SELECT_ADVERT_BY_TITLE, TABLE_NAME, patternTitle);
        return entities.isEmpty() ? null : (List<Advert>) entities.get(0);
    }

    @Override
    public List<Advert> findCountAdvertByAccountIdFk(long AccountId) throws DaoException {
        List<Advert> listAdverts = findBy(SQL_SELECT_ADVERT_BY_ACCOUNT_ID_FK, TABLE_NAME, String.valueOf(AccountId));
        return listAdverts.isEmpty() ? null : listAdverts;
    }

    @Override
    public List<Advert> findAll() throws DaoException {
        return super.findAllEntities(SQL_SELECT_ALL_ADVERTS, TABLE_NAME);
    }

    @Override
    public Advert findBeanById(long index) throws DaoException {
        List<Advert> adverts = super.findBy(SQL_SELECT_ADVERT_BY_ID, TABLE_NAME, String.valueOf(index));
        return adverts.isEmpty() ? null : adverts.get(0);
    }

    @Override
    public void delete(Advert advert) throws DaoException {
        super.delete(advert, SQL_DELETE_ADVERT);
    }

    @Override
    public Advert create(Advert advert) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_ADVERT,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, advert.getTitle());
            preparedStatement.setString(2, advert.getDescription());
            preparedStatement.setString(3, advert.getBrand());
            preparedStatement.setString(4, advert.getModel());
            preparedStatement.setString(5, advert.getColor());
            preparedStatement.setString(6, advert.getBody());
            preparedStatement.setInt(7, advert.getYear());
            preparedStatement.setDouble(8, advert.getEngine());
            preparedStatement.setString(9, advert.getAt());
            preparedStatement.setString(10, advert.getDriveunit());
            preparedStatement.setString(11, advert.getEquipment());
            preparedStatement.setInt(12, advert.getMilage());
            preparedStatement.setString(13, advert.getCrashed());
            preparedStatement.setBigDecimal(14, advert.getPrice());
            preparedStatement.setLong(15, advert.getAccountIdFk());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                advert.setId(generatedKeys.getLong(1));
            } else {
                throw new DaoException(INTERNAL_ERROR);
            }
            return advert;
        } catch (SQLException e) {
            logger.log(Level.ERROR, e);
            throw new DaoException(INTERNAL_ERROR + e.getMessage(), e);
        } finally {
            try {
                closeResources(preparedStatement, connection);
            } catch (Exception e) {
                logger.log(Level.ERROR, INTERNAL_ERROR, e);
            }
        }
    }

    @Override
    public void update(Advert advert) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_ADVERT);
            preparedStatement.setString(1, advert.getTitle());
            preparedStatement.setString(2, advert.getDescription());
            preparedStatement.setString(3, advert.getBrand());
            preparedStatement.setString(4, advert.getModel());
            preparedStatement.setString(5, advert.getColor());
            preparedStatement.setString(6, advert.getBody());
            preparedStatement.setInt(7, advert.getYear());
            preparedStatement.setDouble(8, advert.getEngine());
            preparedStatement.setString(9, advert.getAt());
            preparedStatement.setString(10, advert.getDriveunit());
            preparedStatement.setString(11, advert.getEquipment());
            preparedStatement.setInt(12, advert.getMilage());
            preparedStatement.setString(13, advert.getCrashed());
            preparedStatement.setBigDecimal(14, advert.getPrice());
            preparedStatement.setLong(15, advert.getAccountIdFk());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, e);
            throw new DaoException(INTERNAL_ERROR, e);
        } finally {
            try {
                closeResources(preparedStatement, connection);
            } catch (Exception e) {
                logger.log(Level.ERROR, INTERNAL_ERROR, e);
            }
        }
    }
}
