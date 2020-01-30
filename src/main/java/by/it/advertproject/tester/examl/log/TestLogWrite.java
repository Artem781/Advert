package by.it.advertproject.tester.examl.log;

import by.it.advertproject.command.impl.CreateAdvertCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogWrite {
    private static final Logger logger = LogManager.getLogger(TestLogWrite.class);

    public static void main(String[] args) {
//        logger.trace("Entering application.");
//        Bar bar = new Bar();
//        if (!bar.doIt()) {
//            logger.error("Didn't do it.");
//        }
//        logger.trace("Exiting application.");
        logger.log(Level.TRACE, "Level.TRACE");
        logger.log(Level.DEBUG, "Level.DEBUG");
        logger.log(Level.INFO, "Level.INFO");
        logger.log(Level.WARN, "Level.WARN");
        logger.log(Level.ERROR, "Level.ERROR");
        logger.log(Level.FATAL, "Level.FATAL");




    }
}
