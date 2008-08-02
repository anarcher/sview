package sview;

import java.io.PrintWriter;
import scala.xml.Elem;
import scala.xml.PrettyPrinter; 

public class SViewWriteRenderer implements SViewRenderer {

    private String docType = "";
    private String contentType = "";
    private Elem content = null;

    public void setDocType(String docType) {
        this.docType = docType;
    }
    public String getContentType() {
        return this.contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    public void setContent(Elem content) {
        this.content = content;
    }

    public void print(PrintWriter writer,boolean isprettyprint) {
        String result = null;
        if(isprettyprint == true) {
            PrettyPrinter pp = new PrettyPrinter(120,4);
            result = pp.format(content);
        }
        else {
            result = content.toString();
        }
        writer.print(docType);
        writer.print(result);
    }

}

