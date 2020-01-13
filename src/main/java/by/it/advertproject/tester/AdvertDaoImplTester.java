package by.it.advertproject.tester;

import by.it.advertproject.bean.Advert;
import by.it.advertproject.dao.impl.AdvertDaoImpl;
import by.it.advertproject.exception.DaoException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdvertDaoImplTester {
    public static void main(String[] args) {

        AdvertDaoImpl advertDao = new AdvertDaoImpl();
        Advert advert = new Advert.Builder()
                .withIdAdvert(45)
                .withTitle("kkkkkkkkkkkkkkk")
                .withDescription("adcscsdc")
                .build();
        try {
            advertDao.delete(advert);
            System.out.println("OK");
        } catch (DaoException e) {
            System.out.println("e.getMessage: " + e.getMessage());

        }


    }
}
