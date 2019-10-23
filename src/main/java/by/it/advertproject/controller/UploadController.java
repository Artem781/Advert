package by.it.advertproject.controller;

import by.it.advertproject.command.*;
import by.it.advertproject.exception.CommandException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.advertproject.command.ParameterName.PARAM_NAME_ERROR_MESSAGE;

@WebServlet(name = "/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 10
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadController extends AbstractController {

    private static final String CONTENT_TYPE = "image/jpeg";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response, new PartsRequestContent());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        getImageToClient(request, response);
    }

    private void getImageToClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

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
