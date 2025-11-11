package com.ecom.ecom_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ecom_api.Objects.Request.Auth_Request;
import com.ecom.ecom_api.Objects.Request.New_User;
import com.ecom.ecom_api.Service.User_Service;

@RestController
@RequestMapping("/users")
public class User_Controller {
    @Autowired User_Service user_impl;
    @PostMapping("/register")
    public ResponseEntity<String> register_new_user(@RequestBody New_User user){
        return user_impl.register_new_user(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Auth_Request auth_request){
        return user_impl.authenticate_user(auth_request);
    }
}