//package by.it.databasetask.command;
//
//import by.it.advertproject.bean.Advert;
//import by.it.databasetask.controller.Action;
//import by.it.databasetask.controller.Form;
//import by.it.databasetask.dao.AdvertDao;
//import by.it.advertproject.exception.CommandException;
//
//import javax.servlet.http.HttpServletRequest;
//import java.sql.SQLException;
//import java.util.List;
//
//public class CommandSearchResult implements Command {
//    private final static String SEARCH = "search";
//    private final static String REGEX_SEARCH_WORD = "[a-zA-Zа-яА-Я0-9- ]{0,45}";
//    private final static String ADS_ATTRIBUTE = "ads";
//    private final static String PARAMETER_GO_SEARCH = "gosearch";
//    @Override
//    public Action execute(HttpServletRequest req) throws SQLException, CommandException {
//        if (Form.isPost(req)) {
//            String searchWord = Form.getString(req, SEARCH, REGEX_SEARCH_WORD);
//            List<Advert> adverts = AdvertDao.searchAd(searchWord);
//            req.setAttribute(ADS_ATTRIBUTE, adverts);
//            if (req.getParameter(PARAMETER_GO_SEARCH) != null) {
//                return Action.SEARCHRESULT;
//            }
//        }
//        return Action.SIGN_IN;
//    }
//}
