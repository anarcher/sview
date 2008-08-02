package sview.example.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestParam; 

@Controller
public class IndexController
{
    @RequestMapping("/index.sview")
    public String indexScala(ModelMap models) {
        
        Model model = new Model();
        model.setName("this is model. ");

        models.addAttribute("model",model);
		
        return "sview:indexList:sampleLayout";
    }

    @RequestMapping("/index.jsp")
    public String indexJsp(ModelMap models) {
        
        Model model = new Model();
        model.setName("this is model. ");
        models.addAttribute("model",model);
		
        return "indexList";
    }


}

