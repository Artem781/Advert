package by.it.advertproject.controller;

import by.it.advertproject.command.*;
import by.it.advertproject.exception.CommandException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.advertproject.command.ParameterName.PARAM_NAME_ERROR_MESSAGE;

@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2 // 2mb
        , maxFileSize = 1024 * 1024 * 10 // 10mb
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadController extends AbstractController {
    private static Logger logger = LogManager.getLogger(UploadController.class);
    private static final String CONTENT_TYPE = "image/jpeg";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.log(Level.INFO, "UploadController. doPost");
        process(request, response, new PartsRequestContent());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.log(Level.INFO, "UploadController. doGet");
        getImageToClient(request, response);
    }

    private void getImageToClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.log(Level.INFO, "UploadController. getImageToClient");
        response.setContentType(CONTENT_TYPE);
        RequestContent requestContent = new RequestContent();
        try {
            requestContent.extractValues(request);
            ImageLoadCommand loadCommand = ImageLoadCommandFactory.defineCommand(requestContent);
            response.getOutputStream().write(loadCommand.load(requestContent));
        } catch (CommandException e) {
            response.sendRedirect(CommandUrlBuilder.TO_ERROR
                    .setParams(PARAM_NAME_ERROR_MESSAGE, e.getMessage())
                    .getUrl());
        }
    }
}
