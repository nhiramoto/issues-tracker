package com.hiramoto.issuestracker.web.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private static final Logger log = Logger.getLogger(HomeController.class.getName());

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
    
}
