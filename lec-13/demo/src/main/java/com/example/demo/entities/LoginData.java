package com.example.demo.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {
    @NotBlank(message = "username can not be empty")
    @Size(min = 3,max = 15,message = "between 3-5")    
    private String username;
    @Email(regexp = "",message = "invalid email")
    private String email;
    @AssertTrue //message = "invalid email" parameter can give
    private boolean agreed;
    public boolean isAgreed() {
        return agreed;
    }
    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "LoginData [username=" + username + ", email=" + email + "]";
    }
   
}
