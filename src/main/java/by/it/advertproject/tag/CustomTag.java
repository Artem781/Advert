package by.it.advertproject.tag;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

@SuppressWarnings("serial")
public class CustomTag extends TagSupport {
    private static final Logger LOGGER = LogManager.getLogger(CustomTag.class);
    private static final String TAG = "<em> © IT, Minsk 2019 Designed by Naron Artem </em>";

    @Override
    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        try {
            out.write(TAG);
        } catch (IOException e) {
            LOGGER.log(Level.WARN, "Un none mistake, try again", e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }
}
