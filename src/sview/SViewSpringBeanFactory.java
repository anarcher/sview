package sview;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.util.StringUtils; 

public class SViewSpringBeanFactory extends WebApplicationObjectSupport implements SViewFactory {
    
    private final String DEFAULT_VIEW_DELIMITER= ":";

    public SView getSView(String viewName,ViewBinding viewBinding) {
        String[] str = viewName.split(DEFAULT_VIEW_DELIMITER);
        String sviewName = null;
        String scompositeViewName = null;
        if(str.length >= 1 && StringUtils.hasText(str[0])) sviewName = str[0];
        if(str.length >= 2 && StringUtils.hasText(str[1])) scompositeViewName = str[1];

        WebApplicationContext ctx = super.getWebApplicationContext();
        SView sview = (SView) ctx.getBean(sviewName,new Object[]{viewBinding}); 
        if(StringUtils.hasText(scompositeViewName)) {
            SView sviewcomposite = (SView) ctx.getBean(scompositeViewName,new Object[]{viewBinding,sview});
            return sviewcomposite;
        }
        return sview;
    }
}
