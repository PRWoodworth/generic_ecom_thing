package com.ecom.ecom_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecom.ecom_api.Objects.Models.Product;

@Repository
public interface Product_Repository extends JpaRepository<Product, Long>{
    
}
