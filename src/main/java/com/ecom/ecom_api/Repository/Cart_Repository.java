package com.ecom.ecom_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.ecom_api.Objects.Models.Cart;

@Repository
public interface Cart_Repository extends JpaRepository<Cart, Long>{
    
}
