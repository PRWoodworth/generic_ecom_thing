package com.ecom.ecom_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ecom_api.Objects.Models.Cart;
import com.ecom.ecom_api.Objects.Models.Cart_Item;
import com.ecom.ecom_api.Service.Cart_Service;

@RestController
@RequestMapping("/carts")
public class Cart_Controller {

    @Autowired Cart_Service cart_Service;

    @GetMapping("/get_cart")
    public ResponseEntity<?> get_Cart(long user_id) {
        return cart_Service.get_Cart(user_id);
    }

    @PostMapping("/add_item")
    public ResponseEntity<String> add_Item(long user_id, Cart_Item item) {
        return cart_Service.add_Item(user_id, item);
    }

    @PostMapping("/remove_item")
    public ResponseEntity<String> remove_Item(long user_id, Cart_Item item) {
        return cart_Service.remove_Item(user_id, item);
    }

    @PostMapping("/new_cart")
    public ResponseEntity<Cart> new_Cart(long user_id) {
        return cart_Service.new_Cart(user_id);
    }
}
