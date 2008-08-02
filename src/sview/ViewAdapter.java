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
    private final static String DEFAULT_CONTENT_TYPE = "text/html";
    private String sviewName; 
    private SViewFactory sviewFactory;
    private boolean isPrettyPrint = true;
    private String contentType;

    public ViewAdapter() {
    }

    public void setSViewName(String sviewName) {
        this.sviewName = sviewName;
    }
    public void setSViewFactory(SViewFactory sviewFactory) {
        this.sviewFactory = sviewFactory;
    }
    public void setPrettyPrint(boolean isPrettyPrint) {
        this.isPrettyPrint = isPrettyPrint;
    }


    public String getContentType() {
        return contentType;
    }

    public void render(Map model, HttpServletRequest request,HttpServletResponse response) throws Exception {

        ViewBinding viewBinding = new ViewBinding((Map<String,Object>) model,request,response);

        SView sview = sviewFactory.getSView(sviewName,viewBinding);

        this.contentType = sview.contenttype();
        SViewWriteRenderer renderer = new SViewWriteRenderer(); 
        sview.render(renderer);
        response.setContentType(this.contentType);
        PrintWriter out = response.getWriter();
        renderer.print(out,isPrettyPrint);
        out.close();
    }

}
