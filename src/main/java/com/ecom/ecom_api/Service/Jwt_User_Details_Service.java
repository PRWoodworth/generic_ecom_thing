package com.ecom.ecom_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecom.ecom_api.Objects.User_Principal;
import com.ecom.ecom_api.Objects.Models.User;
import com.ecom.ecom_api.Repository.User_Repository;

@Service
public class Jwt_User_Details_Service implements UserDetailsService{

    @Autowired
    private User_Repository userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.find_by_email_address(email);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        
        return new User_Principal(user);
    }
    
}
