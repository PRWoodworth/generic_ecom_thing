package com.ecom.ecom_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecom.ecom_api.Objects.Models.Cart;
import com.ecom.ecom_api.Objects.Models.Cart_Item;
import com.ecom.ecom_api.Objects.Models.User;
import com.ecom.ecom_api.Repository.Cart_Repository;

@Service
public class Cart_Service {

    @Autowired Cart_Repository cart_Repository;

    public ResponseEntity<String> add_Item(long user_id, Cart_Item item) {
        Cart working_cart;
        if(get_Cart(user_id).getBody().getClass() != Cart.class) {
            working_cart = new_Cart(user_id).getBody();
        } else {
            working_cart = (Cart) get_Cart(user_id).getBody();
        }
        working_cart.getCart_items().add(item);
        cart_Repository.save(working_cart);
        return ResponseEntity.ok("Item added to cart successfully.");
    }

    public ResponseEntity<String> remove_Item() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove_Item'");
    }

    public ResponseEntity<Cart> new_Cart(long user_id) {
        Cart new_cart = new Cart();
        new_cart.setUser_id(user_id);
        return ResponseEntity.ok(cart_Repository.save(new_cart));
    }

    public ResponseEntity<?> get_Cart(long user_id) {
        // get cart for user id
        // if none, return something that IS NOT NULL, because null is sloppy
        Cart cart = cart_Repository.findById(user_id).orElse(null);
        if(cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.ok("No cart found for user ID: " + user_id);
        }
    } 
}
