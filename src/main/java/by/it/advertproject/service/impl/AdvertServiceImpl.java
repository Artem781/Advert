package by.it.advertproject.service.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Advert;
import by.it.advertproject.dao.AdvertDao;
import by.it.advertproject.dao.impl.AdvertDaoImpl;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AdvertParameterValidationState;
import by.it.advertproject.service.AdvertService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static by.it.advertproject.command.Message.*;
import static by.it.advertproject.command.ParameterName.*;

public class AdvertServiceImpl implements AdvertService {
    private static Logger logger = LogManager.getLogger(AdvertServiceImpl.class);
    AdvertDao advertDao = new AdvertDaoImpl();

    public Advert createAdvert(Map<String, String> carAdParameterMap, Long accountId) throws ServiceException {
        logger.log(Level.INFO, "AdvertService. createAdvert");
        AdvertParameterValidationState advertParameterValidationState
                = AdvertParameterValidator.AdvertValidateParameter(carAdParameterMap);
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
                .withAccountIdFk(accountId)
                .build();
        if (advertParameterValidationState == AdvertParameterValidationState.VALID) {
            try {
                advertDao.create(advert);
            } catch (DaoException e) {
                throw new ServiceException(CAN_NOT_CREATE_AD_MESSAGE);
            }
        }
        return advert;
    }

    public List<Advert> findAdvertBelongAccount(Account account) throws DaoException {
        return advertDao.findCountAdvertByAccountIdFk(account.getId());
    }

    public List<Advert> findAllAdvert() throws DaoException {
        return advertDao.findAll();
    }

    private static class AdvertParameterValidator {
        private static final String TITLE_REGEX = "[a-zA-Zа-яА-Я0-9_ ]{1,49}";
        private static final String DESCRIPTION_REGEX = "[a-zA-Zа-яА-Я0-9_ ]{1,1900}";
        private static final String BRAND_REGEX = "[a-zA-Zа-яА-Я0-9-]{1,45}";
        private static final String MODEL_REGEX = "[a-zA-Zа-яА-Я0-9_ ]{1,45}";
        private static final String COLOR_REGEX = "[a-zA-Zа-яА-Я0-9- ]{1,45}";
        private static final String BODY_REGEX = "[a-zA-Zа-яА-Я]{1,45}";
        private static final String PRODUCTION_YEAR_REGEX = "[0-9]{4}";
        private static final String ENGINE_VOLUME_REGEX = "[1-9]{1}[0-9]{3}";
        private static final String AT_TYPE_REGEX = "Automatic|Mechanic{1,19}";
        private static final String DRIVEUNIT_REGEX = "[a-zA-Zа-яА-Я0-9()]{1,45}";
        private static final String EQUIPMENT_REGEX = "[a-zA-Zа-яА-Я]{1,45}";
        private static final String CAR_MILLAGE_REGEX = "\\d{1,9}";
        private static final String IF_CRASHED_REGEX = "wasTrafficAccident|notTrafficAccident";
        private static final String CAR_PRICE_REGEX = "\\d{1,5}";

        public static AdvertParameterValidationState AdvertValidateParameter(Map<String, String> carAdParameterMap) throws ServiceException {
            AdvertParameterValidationState advertParameterValidationState = AdvertParameterValidationState.VALID;
            Map<String, String> advertRegexMap = new HashMap<>();
            advertRegexMap.put(PARAM_CAR_TITLE, TITLE_REGEX);
            advertRegexMap.put(PARAM_CAR_BRAND, BRAND_REGEX);
            advertRegexMap.put(PARAM_CAR_MODEL, MODEL_REGEX);
            advertRegexMap.put(PARAM_CAR_COLOR, COLOR_REGEX);
            advertRegexMap.put(PARAM_CAR_BODY, BODY_REGEX);
            advertRegexMap.put(PARAM_CAR_PRODUCTION_YEAR, PRODUCTION_YEAR_REGEX);
            advertRegexMap.put(PARAM_ENGINE_VOLUME, ENGINE_VOLUME_REGEX);
            advertRegexMap.put(PARAM_AT_TYPE, AT_TYPE_REGEX);
            advertRegexMap.put(PARAM_CAR_DRIVEUNIT, DRIVEUNIT_REGEX);
            advertRegexMap.put(PARAM_CAR_EQUIPMENT, EQUIPMENT_REGEX);
            advertRegexMap.put(PARAM_CAR_MILLAGE, CAR_MILLAGE_REGEX);
            advertRegexMap.put(PARAM_IF_CRASHED, IF_CRASHED_REGEX);
            advertRegexMap.put(PARAM_CAR_DESCRIPTION, DESCRIPTION_REGEX);
            advertRegexMap.put(PARAM_CAR_PRICE, CAR_PRICE_REGEX);
            Map<String, String> errorMessageMapAdvert = new HashMap<>();
            errorMessageMapAdvert.put(PARAM_CAR_TITLE, CAR_TITLE_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_BRAND, CAR_BRAND_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_MODEL, CAR_MODEL_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_COLOR, CAR_COLOR_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_BODY, CAR_BODY_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_PRODUCTION_YEAR, CAR_PRODUCTION_YEAR_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_ENGINE_VOLUME, ENGINE_VOLUME_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_AT_TYPE, AT_TYPE_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_DRIVEUNIT, CAR_DRIVEUNIT_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_EQUIPMENT, CAR_EQUIPMENT_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_MILLAGE, CAR_MILLAGE_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_IF_CRASHED, IF_CRASHED_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_DESCRIPTION, CAR_DESCRIPTION_INCORRECT_FORMAT_MESSAGE);
            errorMessageMapAdvert.put(PARAM_CAR_PRICE, CAR_PRICE_INCORRECT_FORMAT_MESSAGE);
            StringBuilder errorMessageSbAdvert = new StringBuilder();
            for (Map.Entry<String, String> element : carAdParameterMap.entrySet()) {
                if (element.getValue() != null) {
                    if (!Pattern.matches(advertRegexMap.get(element.getKey()), element.getValue())) {
                        errorMessageSbAdvert.append(errorMessageMapAdvert.get(element.getKey())).append("\t");
                    }
                } else {
                    errorMessageSbAdvert.append(errorMessageMapAdvert.get(element.getKey())).append("\t");
                }
            }
            if (errorMessageSbAdvert.length() != 0) {
                throw new ServiceException(String.valueOf(errorMessageSbAdvert));
            }
            return advertParameterValidationState;
        }
    }
}
