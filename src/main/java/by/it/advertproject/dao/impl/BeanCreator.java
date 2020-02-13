package by.it.advertproject.dao.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Advert;
import by.it.advertproject.bean.Bean;
import by.it.advertproject.bean.Role;
import by.it.advertproject.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.it.advertproject.command.Message.INTERNAL_ERROR;

public class BeanCreator<T extends Bean> {
    private static final Logger logger = LogManager.getLogger(BeanCreator.class);

    private static final String ID_ACCOUNTS = "idaccounts";
    private static final String NAME = "name";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String BIRTHDAY = "birthday";
    private static final String EMAIL = "email";
    private static final String TEL = "tel";
    private static final String ROLE = "accesslevel";
    private static final String PHOTO = "photo";

    private static final String ID_ADVERT = "idadvert";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String BRAND = "brand";
    private static final String MODEL = "model";
    private static final String COLOR = "color";
    private static final String BODY = "body";
    private static final String YEAR = "year";
    private static final String ENGINE = "engine";
    private static final String AT = "at";
    private static final String DRIVEUNIT = "driveunit";
    private static final String EQUIPMENT = "equipment";
    private static final String MILEAGE = "mileage";
    private static final String CRASHED = "crashed";
    private static final String PRICE = "price";
    private static final String ACCOUNT_ID_FK = "accountidfk";

    T create(String tableName, ResultSet resultSet) throws SQLException, DaoException {
        try {
            Bean bean;
            switch (tableName) {
                case AccountDaoImpl.TABLE_NAME:
                    bean = new Account.Builder()
                            .withIdAccount(resultSet.getLong(ID_ACCOUNTS))
                            .withName(resultSet.getString(NAME))
                            .withLogin(resultSet.getString(LOGIN))
                            .withPassword(resultSet.getString(PASSWORD))
                            .withBirthday(resultSet.getString(BIRTHDAY))
                            .withEmail(resultSet.getString(EMAIL))
                            .withTel(resultSet.getString(TEL))
                            .withRole(Role.values()[resultSet.getInt(ROLE)])
                            .build();
                    if (resultSet.getBinaryStream(PHOTO) != null) {
                        ((Account) bean).setPhoto(resultSet.getBinaryStream(PHOTO).readAllBytes());
                    }
                    break;
                case AdvertDaoImpl.TABLE_NAME:
                    bean = new Advert.Builder()
                            .withIdAdvert(resultSet.getInt(ID_ADVERT))
                            .withTitle(resultSet.getString(TITLE))
                            .withDescription(resultSet.getString(DESCRIPTION))
                            .withBrand(resultSet.getString(BRAND))
                            .withModel(resultSet.getString(MODEL))
                            .withColor(resultSet.getString(COLOR))
                            .withBody(resultSet.getString(BODY))
                            .withYear(resultSet.getInt(YEAR))
                            .withEngine(resultSet.getDouble(ENGINE))
                            .withAt(resultSet.getString(AT))
                            .withDriveunit(resultSet.getString(DRIVEUNIT))
                            .withEquipment(resultSet.getString(EQUIPMENT))
                            .withMileage(resultSet.getInt(MILEAGE))
                            .withCrashed(resultSet.getString(CRASHED))
                            .withPrice(resultSet.getBigDecimal(PRICE))
                            .withAccountIdFk(resultSet.getInt(ACCOUNT_ID_FK))
                            .build();
                    break;
                default:
                    logger.log(Level.ERROR, INTERNAL_ERROR);
                    throw new DaoException(INTERNAL_ERROR);
            }
            return (T) bean;
        } catch (IOException e) {
            logger.log(Level.ERROR, e);
            throw new DaoException(INTERNAL_ERROR, e);
        }
    }
}
