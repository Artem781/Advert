package by.it.advertproject.service;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Advert;
import by.it.advertproject.bean.Role;
import by.it.advertproject.dao.AccountDao;
import by.it.advertproject.dao.AdvertDao;
import by.it.advertproject.dao.impl.AccountDaoImpl;
import by.it.advertproject.dao.impl.AdvertDaoImpl;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static by.it.advertproject.command.AttributeName.ATTR_NAME_LOGIN;
import static by.it.advertproject.command.Message.*;
import static by.it.advertproject.command.ParameterName.*;
import static by.it.advertproject.command.ParameterName.PARAM_TEL;

public class AdvertService {
    private static final Logger logger = LogManager.getLogger(AccountService.class);


    public Advert createAdvert(Map<String, String> carAdParameterMap, Long accountId) throws ServiceException {
        logger.log(Level.INFO, "from AdvertService) createAdvert method.");
        AdvertParameterValidationState advertParameterValidationState
                = AdvertParameterValidator.AdvertValidateParameter(carAdParameterMap);


        logger.log(Level.INFO, "from AdvertService) createAdvert method. after AdvertParameterValidator ");
        AdvertDao advertDao = new AdvertDaoImpl();
        AccountDao accountDao = new AccountDaoImpl();
        logger.log(Level.INFO, "from AdvertService) createAdvert method. before Advert.Builder() ");

        Advert advert = new Advert.Builder()
                .withTitle(carAdParameterMap.get(PARAM_CAR_TITLE))
                .withDescription(carAdParameterMap.get(PARAM_CAR_DESCRIPTION))
                .withBrand(carAdParameterMap.get(PARAM_CAR_BRAND))
                .withModel(carAdParameterMap.get(PARAM_CAR_MODEL))
                .withColor(carAdParameterMap.get(PARAM_CAR_COLOR))
                .withBody(carAdParameterMap.get(PARAM_CAR_BODY))
                .withYear(Integer.parseInt(carAdParameterMap.get(PARAM_CAR_PRODUCTION_YEAR)))
                .withEngine(Double.parseDouble(carAdParameterMap.get(PARAM_ENGINE_VOLUME)))
                .withAt(carAdParameterMap.get(PARAM_AT_TYPE))
                .withDriveunit(carAdParameterMap.get(PARAM_CAR_DRIVEUNIT))
                .withEquipment(carAdParameterMap.get(PARAM_CAR_EQUIPMENT))
                .withMileage(Integer.parseInt(carAdParameterMap.get(PARAM_CAR_MILLAGE)))
                .withCrashed(carAdParameterMap.get(PARAM_IF_CRASHED))
                .withPrice(BigDecimal.valueOf(Double.parseDouble(carAdParameterMap.get(PARAM_CAR_PRICE))))
                // TODO: 12.10.2019 как правильно записать ошибку? как назвать?
//                .withAccountIdFk(accountDao.findAccountByLogin(carAdParameterMap.get(ATTR_NAME_LOGIN)).getId())
                .withAccountIdFk(accountId)
                .build();
        logger.log(Level.INFO, "from AdvertService) createAdvert method. after Advert.Builder() ");

        if (advertParameterValidationState == AdvertParameterValidationState.VALID) {
            try {
                logger.log(Level.INFO, "from AdvertService) createAdvert method. try block");

                logger.log(Level.INFO, "from AdvertService) createAdvert method. create account with Builder");
                advertDao.create(advert);
                logger.log(Level.INFO, "from AdvertService) createAdvert method. advertDao.create(advertDao)");
            } catch (DaoException e) {
                logger.log(Level.INFO, "from AdvertService) createAdvert method. throw new ServiceException(BUSY_LOGIN_MESSAGE)");
                throw new ServiceException(CAN_NOT_CREATE_AD_MESSAGE);
            }
        }
        return advert;
    }

    private static class AdvertParameterValidator {
        private static final String TITLE_REGEX = "[a-zа-яA-Z-А-Я][a-zа-яA-ZА-Я0-9\\-!?,. ]{7,49}";
        private static final String DESCRIPTION_REGEX = "[a-zа-яA-Z-А-Я0-9.,?!\\- ]{7,2000}";
        private static final String BRAND_REGEX = "[a-zA-Zа-яА-Я0-9- ]{1,45}";
        private static final String MODEL_REGEX = "[a-zA-Zа-яА-Я0-9 ]{1,45}";
        private static final String COLOR_REGEX = "[a-zA-Zа-яА-Я- ]{1,45}";
        private static final String BODY_REGEX = "[a-zA-Zа-яА-Я]{1,45}";
        private static final String DRIVEUNIT_REGEX = "[a-zA-Zа-яА-Я0-9()]{1,45}";
        private static final String EQUIPMENT_REGEX = "[a-zA-Zа-яА-Я]{1,45}";

        public static AdvertParameterValidationState AdvertValidateParameter(Map<String, String> carAdParameterMap){
            AdvertParameterValidationState advertParameterValidationState = AdvertParameterValidationState.VALID;
            logger.log(Level.INFO, "from AdvertService) AdvertParameterValidator) AdvertValidateParameter method.");
            Map<String, String> advertRegexMap = new HashMap<>();
            advertRegexMap.put(PARAM_CAR_TITLE, TITLE_REGEX);
            advertRegexMap.put(PARAM_CAR_BRAND, BRAND_REGEX);
            advertRegexMap.put(PARAM_CAR_MODEL, MODEL_REGEX);
            advertRegexMap.put(PARAM_CAR_COLOR, COLOR_REGEX);
            advertRegexMap.put(PARAM_CAR_BODY, BODY_REGEX);
//            advertRegexMap.put(PARAM_CAR_PRODUCTION_YEAR, PASSWORD_PATTERN);
//            advertRegexMap.put(PARAM_ENGINE_VOLUME, PASSWORD_PATTERN);
//            advertRegexMap.put(PARAM_AT_TYPE, PASSWORD_PATTERN);
            advertRegexMap.put(PARAM_CAR_DRIVEUNIT, DRIVEUNIT_REGEX);
            advertRegexMap.put(PARAM_CAR_EQUIPMENT, EQUIPMENT_REGEX);
//            advertRegexMap.put(PARAM_CAR_MILLAGE, PASSWORD_PATTERN);
//            advertRegexMap.put(PARAM_IF_CRASHED, PASSWORD_PATTERN);
            advertRegexMap.put(PARAM_CAR_DESCRIPTION, DESCRIPTION_REGEX);
//            advertRegexMap.put(PARAM_CAR_PRICE, PASSWORD_PATTERN);
//            advertRegexMap.put(PARAM_CAR_PHOTO_UPLOAD, PASSWORD_PATTERN);
//            advertRegexMap.put(PARAM_CREATE_AD, PASSWORD_PATTERN);

            Map<String, String> errorMessageMapAdvert = new HashMap<>();
            errorMessageMapAdvert.put(PARAM_CAR_TITLE, NAME_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_BRAND, LOGIN_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_MODEL, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_COLOR, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_BODY, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_PRODUCTION_YEAR, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_ENGINE_VOLUME, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_AT_TYPE, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_DRIVEUNIT, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_EQUIPMENT, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_MILLAGE, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_IF_CRASHED, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_DESCRIPTION, PASSWORD_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_PRICE, PASSWORD_INCORRECT_FORMAT_MESSAGE);
//            errorMessageMapAdvert.put(PARAM_CREATE_AD, PASSWORD_CONFIRM_INCORRECT_FORMAT_MESSAGE);
            //14
            logger.log(Level.INFO, "errorMessageMapAdvert size: " + errorMessageMapAdvert.size());
            //8
            logger.log(Level.INFO, "advertRegexMap size: " + advertRegexMap.size());
            //16
            logger.log(Level.INFO, "carAdParameterMap size: " + carAdParameterMap.size());
//            StringBuilder errorMessageSbAdvert = new StringBuilder();
//            for (Map.Entry<String, String> element : carAdParameterMap.entrySet()) {
//                if (!Pattern.matches(advertRegexMap.get(element.getKey()), element.getValue())) {
//                    errorMessageSbAdvert.append(errorMessageMapAdvert.get(element.getKey()) + "\t");
//                }
//            }
//            if (errorMessageSbAdvert.length() != 0) {
//                logger.log(Level.INFO, "errorMessageSbAdvert !== null. errorMessageSbAdvert: " + errorMessageSbAdvert);
//                throw new ServiceException(String.valueOf(errorMessageSbAdvert));
//            }
            logger.log(Level.INFO, "from AdvertService) AdvertParameterValidator) AdvertValidateParameter method. " +
                    "return AdvertParameterValidationState: " + advertParameterValidationState.name());
            return advertParameterValidationState;
        }
    }
}
