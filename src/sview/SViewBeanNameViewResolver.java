package sview;

import java.util.Map;
import java.util.Locale;

import org.springframework.core.Ordered;
import org.springframework.util.StringUtils; 
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class SViewBeanNameViewResolver extends WebApplicationObjectSupport implements ViewResolver,Ordered {

    private final static String DELIMITER = "sview:";
    private int order = Integer.MAX_VALUE;
    private String sviewFactoryBeanName = "sviewSpringBeanFactory";
    private boolean isPrettyPrint = true;
    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;	
    }

    public void setSviewFactoryBeanName(String sviewFactoryBeanName) {
        this.sviewFactoryBeanName = sviewFactoryBeanName;
    }

    public void setPrettyPrint(boolean isPrettyPrint) {
        this.isPrettyPrint = isPrettyPrint;
    }

    public View resolveViewName(String viewName,Locale locale) throws Exception {
        if(viewName.indexOf(DELIMITER) < 0) {
           return null; 
        }

        String sviewName = viewName.substring(viewName.indexOf(DELIMITER)+6);

        WebApplicationContext ctx = super.getWebApplicationContext();
        SViewFactory sviewFactory = (SViewFactory) ctx.getBean(this.sviewFactoryBeanName);
    
        ViewAdapter view = new ViewAdapter();
        view.setSViewName(sviewName);
        view.setSViewFactory(sviewFactory);
        view.setPrettyPrint(isPrettyPrint);

        return view;
    }	
}
