package by.it.advertproject.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

@SuppressWarnings("serial")
public class CustomTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().print("<b>Error: </b><b>");
        getJspBody().invoke(null);
        getJspContext().getOut().print("</b>");
    }
}
