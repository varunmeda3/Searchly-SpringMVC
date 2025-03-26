package com.searchly;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

    @RequestMapping("/home")
    public String home (){
        return "home";
    }

    @RequestMapping("/search")
    public RedirectView search(@RequestParam("query") String query){
        RedirectView redirectView = new RedirectView();
        String url = "https://www.google.com/search?q=" + query;

        if (query.length() == 0)  
            redirectView.setUrl("redirect:/home");
        else  
            redirectView.setUrl(url);
        
        return redirectView;
    }
}

