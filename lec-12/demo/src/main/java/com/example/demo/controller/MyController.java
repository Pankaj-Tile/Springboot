package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class MyController {

    @RequestMapping(value = "/about", method=RequestMethod.GET)
    public String about(Model model){
        System.out.println("...in about");
        model.addAttribute("name","pankaj");
        model.addAttribute("date",new Date());
        return "about";// about.html
    }
    @GetMapping("/iterate")
    public String loop(Model m){
        List<String> names=List.of("ankit","pankaj","dada");
        m.addAttribute("names", names);
        return "iterate";
    }
    @GetMapping("/condition")
    public String cond(Model m){
        
        m.addAttribute("isactive", true);
        m.addAttribute("gender", "F");
        return "condition";
    }

    @GetMapping("/service")
    public String service(Model m){
        m.addAttribute("title", "i like it");
        m.addAttribute("subtitle", new Date());
        return "service";
    }
    @GetMapping("/newabout")
    public String newabout(Model m){
       
        return "aboutnew";
    }
    
}
