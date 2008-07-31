package sview;

import java.util.Map;
import java.util.Locale;

import org.springframework.core.Ordered;
import org.springframework.util.StringUtils; 
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class SViewResolver extends WebApplicationObjectSupport implements ViewResolver,Ordered {

    private final static String DELIMITER = ":";
    private int order = Integer.MAX_VALUE;

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;	
    }

    public View resolveViewName(String viewName,Locale locale) throws Exception {
        View view = new ViewAdapter(viewName,super.getWebApplicationContext());
        return view;
    }	
}
