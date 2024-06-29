package com.lec1.setupcheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class hellow {
    @GetMapping("/hellow")  //Context path
    public String sayHellow(){
        return "Hi Spring World";
    }
}
