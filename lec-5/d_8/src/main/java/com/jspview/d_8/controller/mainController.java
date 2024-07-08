package com.jspview.d_8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
    @RequestMapping("/")
    public String home(){
        return "home";
    } 
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    } 
}
