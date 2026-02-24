package com.greetlabs.School_Application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value={"","/","/home"})
    public String displayHomePage(){
        //model.addAttribute("username","Ravi Kiran Reddy");
        return "index.html";
    }
}
