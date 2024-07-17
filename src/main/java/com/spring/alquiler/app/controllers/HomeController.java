package com.spring.alquiler.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String HomePage() {
        return "pages/landing_page";
    }
}