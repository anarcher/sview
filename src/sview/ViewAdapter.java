package sview;

import java.util.Map;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.util.StringUtils; 
import org.springframework.web.servlet.View; 

public class ViewAdapter implements View {
    private final static String DEFAULT_DELIMITER = ":";
    protected final static String DEFAULT_CONTENT_TYPE = "text/html";

    private String viewName; 
    private String compositeViewName;
    private WebApplicationContext ctx;

    public ViewAdapter(String viewName,WebApplicationContext ctx) {
        this.ctx = ctx;
        this.viewName = viewName;
        String[] str = viewName.split(DEFAULT_DELIMITER);
        if(str.length >=1 && StringUtils.hasText(str[0])) this.viewName = str[0];
        if(str.length >=2 && StringUtils.hasText(str[1])) this.compositeViewName = str[1];
    }

    public String getContentType() {
        return DEFAULT_CONTENT_TYPE; 
    }

    public void render(Map model, HttpServletRequest request,HttpServletResponse response) throws Exception {

        ViewBinding viewBinding = new ViewBinding((Map<String,Object>) model,request,response);

        String result = null;
        SView view = (SView) ctx.getBean(viewName,new Object[] {viewBinding}); 

        if(StringUtils.hasText(compositeViewName)) { 
           SView compositeView = (SView) 
                            ctx.getBean(compositeViewName,new Object[] {viewBinding,view});

           result = SViewRenderer.render(compositeView);
        }
        else {
           result = SViewRenderer.render(view);
        }

        response.setContentType(getContentType());
        PrintWriter out = response.getWriter();
        out.print(result);  
    }

}
