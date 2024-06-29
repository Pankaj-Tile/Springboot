package com.lec2;

import org.springframework.web.bind.annotation.RestController;

import lec22.lec2_3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class checklec2 {

    private lec2_3 dog;
    @GetMapping("/check")
    public String getMethodName(@RequestParam String param) {
        return dog.fun();
    }
    
}
