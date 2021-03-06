package by.it.advertproject.command;

import by.it.advertproject.exception.CommandException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

import static by.it.advertproject.command.Message.INTERNAL_ERROR;
import static by.it.advertproject.command.Message.LOAD_FILE_ERROR_MESSAGE;

public class PartsRequestContent extends RequestContent {
    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(PartsRequestContent.class);
    private Collection<Part> parts;

    public void extractValues(HttpServletRequest request) throws CommandException {
        logger.log(Level.INFO, "PartsRequestContent");
        super.extractValues(request);
        try {
            parts = request.getParts();
        } catch (IOException e) {
            logger.log(Level.ERROR, e);
            throw new CommandException(LOAD_FILE_ERROR_MESSAGE, e);
        } catch (ServletException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new CommandException(INTERNAL_ERROR);
        } catch (IllegalStateException e) {
            logger.log(Level.INFO, e.getMessage());
        }
    }

    public Collection<Part> getParts() {
        return parts;
    }
}
