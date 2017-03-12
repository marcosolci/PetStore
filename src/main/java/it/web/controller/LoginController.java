package it.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcomePage");
        return model;
    }   
             
    @RequestMapping(value = "/loginPage**", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
          @RequestParam(value = "logout", required = false) String logout) {
                
        ModelAndView model = new ModelAndView();
        if (error != null) { 
            model.addObject("error", "Invalid Credentials provided.");
        } 
 
        if (logout != null) {
            model.addObject("message", "Logged out from JournalDEV successfully.");
        }

        model.setViewName("loginPage");
        return model;
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

            ModelAndView model = new ModelAndView();
            model.addObject("title", "Spring Security Hello World");
            model.addObject("message", "This is protected page!");
            model.setViewName("admin");

            return model;

    }
}