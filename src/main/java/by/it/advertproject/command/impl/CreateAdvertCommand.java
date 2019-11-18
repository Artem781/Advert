package by.it.advertproject.command.impl;

import by.it.advertproject.bean.Account;
import by.it.advertproject.bean.Advert;
import by.it.advertproject.command.*;
import by.it.advertproject.exception.DaoException;
import by.it.advertproject.exception.ServiceException;
import by.it.advertproject.service.AccountService;
import by.it.advertproject.service.AdvertService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.it.advertproject.command.AttributeName.*;
import static by.it.advertproject.command.ParameterName.*;

public class CreateAdvertCommand implements Command {
    private static final Logger logger = LogManager.getLogger(CreateAdvertCommand.class);

    @Override
    public Router execute(RequestContent content) {
        logger.log(Level.INFO, "from CreateAdvertCommand");
        String page;
        // TODO: 15.10.2019 параметры я записываю в HashMap, и потом эту Map я передаю в сервис класс
        // TODO: 15.10.2019 Map параметризована <String, String>  будет ли лучше параметризовать <String, Object>?
        //так как Id тип Long.
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
        String ifCrashedTrue = content.getRequestParameters(PARAM_IF_CRASHED_TRUE, 0);
        carAdParameterMap.put(PARAM_IF_CRASHED, ifCrashedTrue);
        String ifCrashedFalse = content.getRequestParameters(PARAM_IF_CRASHED_FALSE, 0);
        carAdParameterMap.put(PARAM_IF_CRASHED, ifCrashedFalse);
        String carDescription = content.getRequestParameters(PARAM_CAR_DESCRIPTION, 0);
        carAdParameterMap.put(PARAM_CAR_DESCRIPTION, carDescription);
        String carPrice = content.getRequestParameters(PARAM_CAR_PRICE, 0);
        carAdParameterMap.put(PARAM_CAR_PRICE, carPrice);
//        String carPhotoUpload = content.getRequestParameters(PARAM_CAR_PHOTO_UPLOAD, 0);
//        carAdParameterMap.put(PARAM_CAR_PHOTO_UPLOAD, carPhotoUpload);
        String createAd = content.getRequestParameters(PARAM_CREATE_AD, 0);
        carAdParameterMap.put(PARAM_CREATE_AD, createAd);
        String accountLogin = (String) content.getSessionAttribute(ATTR_NAME_LOGIN);
        carAdParameterMap.put(ATTR_NAME_LOGIN, accountLogin);
//        String accountId = (String) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
        Long accountId = (Long) content.getSessionAttribute(ATTR_NAME_ACCOUNT_ID);
//        carAdParameterMap.put(ATTR_NAME_ACCOUNT_ID, accountId);
//    Role role = Role.valueOf(request.getParameter(PARAM_ACCESS_LEVEL).toUpperCase());
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
        content.putRequestAttribute(ATTR_CAR_IF_CRASHED, ifCrashedTrue);
        content.putRequestAttribute(ATTR_CAR_IF_CRASHED, ifCrashedFalse);
        content.putRequestAttribute(ATTR_CAR_DESCRIPTION, carDescription);
        content.putRequestAttribute(ATTR_CAR_PRICE, carPrice);
//        content.putRequestAttribute(PARAM_CAR_PHOTO_UPLOAD, carPhotoUpload);
        TransmissionType transmissionType;
        Account account;
        Advert advert;
        AccountService accountService = new AccountService();
        AdvertService advertService = new AdvertService();
        logger.log(Level.INFO, "from CreateAdvertCommand before try block");
        String messageManager;
        try {
            advert = advertService.createAdvert(carAdParameterMap, accountId);
            account = accountService.findAccount(accountLogin);
            List<Advert> sessionAttributeList = advertService.findAdvertBelongAccount(account);
            logger.log(Level.INFO, "from CreateAdvertCommand. sessionAttributeList.add(advert);");
            content.putSessionAttribute(ATTR_NAME_LIST_ADVERT, sessionAttributeList);
//            content.putRequestAttribute(ATTR_CREATED_ADVERT, "Well done");
//            // TODO: 15.10.2019 Можно ли самого Advert как объект передавать в сессию или request?
            content.putRequestAttribute(ATTR_OBJECT_ADVERT, advert);
            content.putRequestAttribute(ATTR_NAME_LOGIN, accountLogin);
            content.putRequestAttribute(ATTR_NAME_ACCOUNT_ID, account.getId());
            logger.log(Level.INFO, "from CreateAdvertCommand) try block) advert: " + advert);
            page = CommandUrlBuilder.TO_USER_PROFILE_PAGE
                    .setParams(PARAM_NAME_PAGE_ID, accountId.toString()).getUrl();
            transmissionType = TransmissionType.FORWARD;
            logger.log(Level.INFO, "from CreateAdvertCommand. page: " + page);
        } catch (ServiceException e) {
            logger.log(Level.INFO, "from CreateAdvertCommand. catch block. e.getMessage(): " + e.getMessage());
//            messageManager = e.getMessage().trim();
//            content.putRequestAttribute(ATTR_NAME_ERROR_MESSAGE,
//                    MessageManager.getProperty(MESSAGE_INCORRECT_SIGN_UP_DATA, String.valueOf(ENGLISH)));
//            String[] splitAttr = messageManager.split("\t");
//            for (String element : splitAttr) {
//                logger.log(Level.INFO, "element: " + element);
//                switch (element.trim()) {
//                    case NAME_INCORRECT_FORMAT_MESSAGE:
//                        content.putRequestAttribute(ATTR_NAME_ERROR_NAME,
//                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
//                        break;
//                    case LOGIN_INCORRECT_FORMAT_MESSAGE:
//                        content.putRequestAttribute(ATTR_NAME_ERROR_LOGIN,
//                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
//                        break;
//                    case PASSWORD_INCORRECT_FORMAT_MESSAGE:
//                        content.putRequestAttribute(ATTR_NAME_ERROR_PASSWORD,
//                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
//                        break;
//                    case BIRTHDAY_INCORRECT_FORMAT_MESSAGE:
//                        content.putRequestAttribute(ATTR_NAME_ERROR_BIRTHDAY,
//                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
//                        break;
//                    case EMAIL_INCORRECT_FORMAT_MESSAGE:
//                        content.putRequestAttribute(ATTR_NAME_ERROR_EMAIL,
//                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
//                        break;
//                    case TEL_INCORRECT_FORMAT_MESSAGE:
//                        content.putRequestAttribute(ATTR_NAME_ERROR_TEL,
//                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
//                        break;
//                    case NON_CONFIRM_PASSWORD_MESSAGE:
//                        content.putRequestAttribute(ATTR_NAME_PASS_NO_EQUALS_PASS_CONFIRM,
//                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
//                        break;
//                    case BUSY_LOGIN_MESSAGE:
//                        content.putRequestAttribute(ATTR_NAME_BUSY_LOGIN,
//                                MessageManager.getProperty(element, String.valueOf(ENGLISH)));
//                        break;
//                }
//            }
            page = CommandUrlBuilder.TO_CREATE_ADVERT_PAGE
                    .setParams(PARAM_NAME_FEEDBACK, "").getUrl();
            transmissionType = TransmissionType.FORWARD;
        } catch (DaoException e) {
            logger.log(Level.INFO, "from CreateAdvertCommand. catch block. DaoException e.getMessage(): " + e.getMessage());

            page = CommandUrlBuilder.TO_CREATE_ADVERT_PAGE
                    .setParams(PARAM_NAME_FEEDBACK, "").getUrl();
            transmissionType = TransmissionType.FORWARD;        }
        return new Router(page, transmissionType);
    }
}

