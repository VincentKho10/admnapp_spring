package com.example.admnapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
    
    @RequestMapping(path="/users", method=RequestMethod.GET)
    public String showWelcomePage(Model model) {
        model.addAttribute("message", "Welcome to users");
        return "users";
    }

}
