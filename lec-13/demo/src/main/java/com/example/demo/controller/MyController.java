package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.LoginData;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class MyController {

    @RequestMapping(value = "/about", method=RequestMethod.GET)
    public String about(Model model){
        System.out.println("...in about");
        model.addAttribute("name","pankaj");
        model.addAttribute("date",new Date());
        return "about";// about.html
    }
    @GetMapping("/form")
    public String form(Model model){
       System.out.println("in form page");
       model.addAttribute("LoginData", new LoginData());
        return "form";
    }
    @PostMapping("/action")
    public String process(@Valid @ModelAttribute("LoginData") LoginData loginData, BindingResult result){
        if(result.hasErrors()){
            System.out.println(result);
            return "form";
           }
       System.out.println(loginData);
     
        return "success";
    }
    
   
}
