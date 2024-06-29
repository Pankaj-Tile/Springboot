package com.lec2.lec2;

import org.springframework.web.bind.annotation.RestController;

// import lec22.lec2_3;  // this will give error
import com.lec2.lec2.lec2_3; //this line resolve error

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController  //
public class checklec2 {
    @Autowired  // its helps get bins form ioc container
    private lec2_3 dog;
    @GetMapping("/check")  //this is map to page specific url
    public String check() {
        return dog.fun();
    }
    
}
