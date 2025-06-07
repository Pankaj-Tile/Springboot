package com.smartcontact.project1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.smartcontact.project1.dao.UserRepository;
import com.smartcontact.project1.entity.User;
import com.smartcontact.project1.helper.message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    // @GetMapping("/test")
    // @ResponseBody
    // public String test(){
    //     User user=new User();
    //     user.setName("pankaj");
    //     user.setEmail("abc@123.com");
    //     userRepository.save(user);
    //     return "working";
    // }
   
    @RequestMapping("/")
    public String homeController(org.springframework.ui.Model model){
        model.addAttribute("title","Home-smart contact manager");
     
        return "home";
    }
    @RequestMapping("/about")
    public String aboutController(org.springframework.ui.Model model){
        model.addAttribute("title","About-smart contact manager");
     
        return "about";
    }
    @RequestMapping("/signup")
    public String signupController(org.springframework.ui.Model model){
        model.addAttribute("title","signup-smart contact manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/do_register")
    public String registerController(@Valid @ModelAttribute("user") User user ,BindingResult bResult,@RequestParam(value = "agreed",defaultValue = "false") Boolean agreed,Model model ,HttpSession session){
        model.addAttribute("title","signup-smart contact manager");
        session.removeAttribute("message");
        try {
           
            if(!agreed){
                System.out.println("not agreed");
                throw new Exception("not agreed");
            }
            if(bResult.hasErrors()){
                
                System.out.println("Error"+bResult.toString());
                model.addAttribute("user", user);

               return "signup";
            }
            user.setRole("ROLE_USER");
            user.setEnabled(true);
            user.setImageUrl("default.png");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            System.out.println("Agreement"+ agreed);
            System.out.println("user"+user); // this is values get from the from
            User result=this.userRepository.save(user);  //this result is that get save in database
            // model.addAttribute("user", result);  // creating new attribute with values similar to user or result
            System.out.println(result.getId());
           
            model.addAttribute("user", new User());
            session.setAttribute("message", new message("sucessfully register","alert-success"));

            return "signup";
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            model.addAttribute("user", user);
            

            session.setAttribute("message", new message("something went wrong "+e.getMessage(),"alert-error"));
            return "signup";
        }
       
    }
    
    

    
}
