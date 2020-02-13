package by.it.advertproject.command.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Advert;
import by.it.advertproject.command.*;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import by.it.advertproject.service.AdvertService;
import by.it.advertproject.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.Message.*;
import static by.it.advertproject.command.ParameterName.*;
import static by.it.advertproject.command.impl.SetLanguageCommand.ENGLISH;

public class CreateAdvertCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(CreateAdvertCommand.class);

    @Override
    public Router execute(RequestContent content) {
        LOGGER.log(Level.INFO, "CreateAdvertCommand.");
        String page;
        Map<String, String> carAdParameterMap = new HashMap<>();
        String carTitle = content.getRequestParameters(PARAM_CAR_TITLE, 0);
        carAdParameterMap.put(PARAM_CAR_TITLE, carTitle);
        String carBrand = content.getRequestParameters(PARAM_CAR_BRAND, 0);
        carAdParameterMap.put(PARAM_CAR_BRAND, carBrand);
        String carModel = content.getRequestParameters(PARAM_CAR_MODEL, 0);
        carAdParameterMap.put(PARAM_CAR_MODEL, carModel);
        String carColor = content.getRequestParameters(PARAM_CAR_COLOR, 0);
        carAdParameterMap.put(PARAM_CAR_COLOR, carColor);
        String carBody = content.getRequestParameters(PARAM_CAR_BODY, 0);
        carAdParameterMap.put(PARAM_CAR_BODY, carBody);
        String carYear = content.getRequestParameters(PARAM_CAR_PRODUCTION_YEAR, 0);
        carAdParameterMap.put(PARAM_CAR_PRODUCTION_YEAR, carYear);
        String carEenginevolume = content.getRequestParameters(PARAM_ENGINE_VOLUME, 0);
        carAdParameterMap.put(PARAM_ENGINE_VOLUME, carEenginevolume);
        String carAtType = content.getRequestParameters(PARAM_AT_TYPE, 0);
        carAdParameterMap.put(PARAM_AT_TYPE, carAtType);
        String carDriveUnit = content.getRequestParameters(PARAM_CAR_DRIVEUNIT, 0);
        carAdParameterMap.put(PARAM_CAR_DRIVEUNIT, carDriveUnit);
        String carEquipment = content.getRequestParameters(PARAM_CAR_EQUIPMENT, 0);
        carAdParameterMap.put(PARAM_CAR_EQUIPMENT, carEquipment);
        String carMillage = content.getRequestParameters(PARAM_CAR_MILLAGE, 0);
        carAdParameterMap.put(PARAM_CAR_MILLAGE, carMillage);
        String ifCrashed = content.getRequestParameters(PARAM_IF_CRASHED, 0);
        carAdParameterMap.put(PARAM_IF_CRASHED, ifCrashed);
        String carDescription = content.getRequestParameters(PARAM_CAR_DESCRIPTION, 0);
        carAdParameterMap.put(PARAM_CAR_DESCRIPTION, carDescription);
        String carPrice = content.getRequestParameters(PARAM_CAR_PRICE, 0);
        carAdParameterMap.put(PARAM_CAR_PRICE, carPrice);
        String accountLogin = (String) content.getSessionAttribute(ATTR_NAME_LOGIN);
        Long accountId = (Long) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
        content.putRequestAttribute(ATTR_CAR_TITLE, carTitle);
        content.putRequestAttribute(ATTR_CAR_BRAND, carBrand);
        content.putRequestAttribute(ATTR_CAR_MODEL, carModel);
        content.putRequestAttribute(ATTR_CAR_COLOR, carColor);
        content.putRequestAttribute(ATTR_CAR_BODY, carBody);
        content.putRequestAttribute(ATTR_CAR_PRODUCTION_YEAR, carYear);
        content.putRequestAttribute(ATTR_CAR_ENGINE_VOLUME, carEenginevolume);
        content.putRequestAttribute(ATTR_CAR_AT_TYPE, carAtType);
        content.putRequestAttribute(ATTR_CAR_DRIVEUNIT, carDriveUnit);
        content.putRequestAttribute(ATTR_CAR_EQUIPMENT, carEquipment);
        content.putRequestAttribute(ATTR_CAR_MILLAGE, carMillage);
        content.putRequestAttribute(ATTR_CAR_IF_CRASHED, ifCrashed);
        content.putRequestAttribute(ATTR_CAR_DESCRIPTION, carDescription);
        content.putRequestAttribute(ATTR_CAR_PRICE, carPrice);
        TransmissionType transmissionType;
        Account account;
        Advert advert;
        AccountService accountService = new AccountService();
        AdvertService advertService = new AdvertService();
        String messageManager;
        try {
            advert = advertService.createAdvert(carAdParameterMap, accountId);
            account = accountService.findAccount(accountLogin);
            List<Advert> listUserAdvert = advertService.findAdvertBelongAccount(account);
            content.putSessionAttribute(ATTR_NAME_LIST_USER_ADVERT, listUserAdvert);
            List<Advert> allAdvertList = advertService.findAllAdvert();
            content.putSessionAttribute(ATTR_NAME_LIST_ALL_ADVERT, allAdvertList);
            content.putRequestAttribute(ATTR_OBJECT_ADVERT, advert);
            content.putRequestAttribute(ATTR_NAME_LOGIN, accountLogin);
            content.putRequestAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
            page = CommandUrlBuilder.TO_USER_PROFILE_PAGE
                    .setParams(PARAM_NAME_PAGE_ID, accountId.toString()).getUrl();
            transmissionType = TransmissionType.FORWARD;
        } catch (ServiceException e) {
            messageManager = e.getMessage().trim();
            content.putRequestAttribute(ATTR_NAME_ERROR_MESSAGE_CREATE_ADVERT,
                    MessageManager.getProperty(MESSAGE_INCORRECT_CREATE_AD_DATA, String.valueOf(ENGLISH)));
            String[] splitAttr = messageManager.split("\t");
            for (String element : splitAttr) {
                switch (element.trim()) {
                    case CAR_TITLE_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_CAR_TITLE,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case CAR_BRAND_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_CAR_BRAND,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case CAR_MODEL_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_CAR_MODEL,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case CAR_COLOR_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_CAR_COLOR,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case CAR_BODY_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_CAR_BODY,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case CAR_PRODUCTION_YEAR_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_CAR_PRODUCTION_YEAR,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case ENGINE_VOLUME_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_ENGINE_VOLUME,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case AT_TYPE_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_AT_TYPE_INCORRECT,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case CAR_DRIVEUNIT_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_CAR_DRIVEUNIT,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case CAR_EQUIPMENT_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_CAR_EQUIPMENT,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case CAR_MILLAGE_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_CAR_MILLAGE,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case IF_CRASHED_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_IF_CRASHED,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case CAR_DESCRIPTION_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_CAR_DESCRIPTION,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                    case CAR_PRICE_INCORRECT_FORMAT_MESSAGE:
                        content.putRequestAttribute(ATTR_NAME_ERROR_CAR_PRICE,
                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
                        break;
                }
            }
            page = CommandUrlBuilder.TO_CREATE_ADVERT_PAGE
                    .setParams(PARAM_NAME_FEEDBACK, "").getUrl();
            transmissionType = TransmissionType.FORWARD;
        } catch (DaoException e) {
            page = CommandUrlBuilder.TO_CREATE_ADVERT_PAGE
                    .setParams(PARAM_NAME_FEEDBACK, "").getUrl();
            transmissionType = TransmissionType.FORWARD;
        }
        return new Router(page, transmissionType);
    }
}

