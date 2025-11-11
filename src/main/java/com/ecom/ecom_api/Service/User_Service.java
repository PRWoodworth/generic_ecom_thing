package com.ecom.ecom_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.ecom_api.Config.Jwt_Utils;
import com.ecom.ecom_api.Objects.Models.User;
import com.ecom.ecom_api.Objects.Request.Auth_Request;
import com.ecom.ecom_api.Objects.Request.New_User;
import com.ecom.ecom_api.Repository.User_Repository;

@Service        
public class User_Service {

    @Autowired private User_Repository user_repo;
    @Autowired private Jwt_Utils jwt_service;
    @Autowired AuthenticationManager authManager;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<String> register_new_user(New_User new_user){
        User found_User = user_repo.find_by_email_address(new_user.getEmail());
        String response_body;
        HttpStatus response_status;
        if(found_User == null){
            User user = new User();
            user.setEmail(new_user.getEmail());
            user.setFirst_name(new_user.getFirst_name());
            user.setLast_name(new_user.getLast_name());
            user.setPassword(encoder.encode(new_user.getPassword()));
            user_repo.save(user);
            response_body = "User registered successfully.";
            response_status = HttpStatus.OK;
        } else {
            response_body = "Email is already in use.";
            response_status = HttpStatus.CONFLICT;
        }
        ResponseEntity<String> response = new ResponseEntity<>(response_body, response_status);
        return response;
    }
    public ResponseEntity<String> authenticate_user(Auth_Request auth_request) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(auth_request.getUsername(), auth_request.getPassword()));
        String response_body;
        HttpStatus response_status = null;
        if (authentication.isAuthenticated() == true) {
            response_body = jwt_service.generateToken(auth_request.getUsername());
            response_status = HttpStatus.OK;
        } else {
            response_body = "Incorrect email or password.";
            response_status = HttpStatus.UNAUTHORIZED;
        }
        ResponseEntity<String> response = new ResponseEntity<>(response_body, response_status);
        return response;
    }
    
}
