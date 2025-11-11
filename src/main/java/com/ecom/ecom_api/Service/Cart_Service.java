package com.ecom.ecom_api.Service;

import org.springframework.http.ResponseEntity;

import com.ecom.ecom_api.Objects.Models.Cart;
import com.ecom.ecom_api.Objects.Models.User;

public class Cart_Service {

    public ResponseEntity<String> add_Item() {
        //TODO: get cart based on incoming user ID/session
        //TODO: if no existing cart, create one
        //TODO: else add item to existing cart
        throw new UnsupportedOperationException("Unimplemented method 'add_Item'");
    }

    public ResponseEntity<String> remove_Item() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove_Item'");
    }

    public ResponseEntity<String> new_Cart(User user) {
        Cart new_cart = new Cart();
        new_cart.setUser(user);
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'new_Cart'");
    }

    public ResponseEntity<String> get_Cart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get_Cart'");
    }
    
}
