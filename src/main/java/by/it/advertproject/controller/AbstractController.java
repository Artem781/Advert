package by.it.advertproject.controller;

import by.it.advertproject.command.*;
import by.it.advertproject.exception.CommandException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.advertproject.command.ParameterName.PARAM_NAME_ERROR_MESSAGE;

public abstract class AbstractController extends HttpServlet {
    private static Logger logger = LogManager.getLogger(AbstractController.class);

    protected void process(HttpServletRequest request, HttpServletResponse response,
                           RequestContent content) throws ServletException, IOException {
        logger.log(Level.INFO, "AbstractController.");
        try {
            content.extractValues(request);
            ActionCommand command = CommandProvider.defineCommand(content);
            Router router = command.execute(content);
            content.insertAttributes(request);
            if (router.getTransmissionType().equals(TransmissionType.FORWARD)) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(router.getPath());
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + router.getPath());
            }
        } catch (CommandException e) {
            response.sendRedirect(CommandUrlBuilder.TO_ERROR
                    .setParams(PARAM_NAME_ERROR_MESSAGE, e.getMessage())
                    .getUrl());
        }
    }
}