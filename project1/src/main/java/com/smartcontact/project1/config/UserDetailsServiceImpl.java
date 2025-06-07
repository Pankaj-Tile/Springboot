package com.smartcontact.project1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smartcontact.project1.dao.UserRepository;
import com.smartcontact.project1.entity.User;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.getUserByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("username not found");
        }
        CustomUserDetails customUserDetails=new CustomUserDetails(user);

        return customUserDetails;
    }
    
}
