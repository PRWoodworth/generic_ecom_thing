package com.ecom.ecom_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ecom_api.Objects.Models.User;
import com.ecom.ecom_api.Service.Cart_Service;

@RestController
@RequestMapping("/carts")
public class Cart_Controller {

    @Autowired Cart_Service cart_Service;

    @GetMapping("/get_cart")
    public ResponseEntity<String> get_Cart() {
        return cart_Service.get_Cart();
    }

    @PostMapping("/add_item")
    public ResponseEntity<String> add_Item() {
        return cart_Service.add_Item();
    }

    @PostMapping("/remove_item")
    public ResponseEntity<String> remove_Item() {
        return cart_Service.remove_Item();
    }

    @PostMapping("/new_cart")
    public ResponseEntity<String> new_Cart(User user) {
        return cart_Service.new_Cart(user);
    }
}
