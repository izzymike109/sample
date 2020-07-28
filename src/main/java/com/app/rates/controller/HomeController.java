package com.app.rates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home Controller class to provide entry point for web front end on application.
 *
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
