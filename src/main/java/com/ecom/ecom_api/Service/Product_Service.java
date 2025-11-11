package com.ecom.ecom_api.Service;
import com.ecom.ecom_api.Objects.Models.Product;
import com.ecom.ecom_api.Objects.Request.New_Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecom.ecom_api.Repository.Product_Repository;

@Service
public class Product_Service {
    @Autowired private Product_Repository product_repo;

    public ResponseEntity<String> add_product(New_Product product){
        Product inserted_product = product_repo.save(new Product(product.getProduct_title(), product.getProduct_description()));
        ResponseEntity<String> response = new ResponseEntity<>(inserted_product.toString(), HttpStatus.OK);
        return response;
    }

    public ResponseEntity<String> add_product_list(List<New_Product> products){
        for (New_Product new_Product : products) {
            add_product(new_Product);
        }
        ResponseEntity<String> response = new ResponseEntity<>(products.toString(), HttpStatus.OK);
        return response;
    }

    public ResponseEntity<String> update_product(Product product){
        Product product_to_update = product_repo.getReferenceById(product.getId());
        product_to_update.setProduct_description(product.getProduct_description());
        product_to_update.setProduct_description(product.getProduct_description());
        product_repo.save(product_to_update);
        ResponseEntity<String> response = new ResponseEntity<>(product_repo.toString(), HttpStatus.OK);
        return response;
    }

    public ResponseEntity<String> get_product(long product_id){
        Product found_product = product_repo.getReferenceById(product_id);
        ResponseEntity<String> response = new ResponseEntity<>(found_product.toString(), HttpStatus.OK);
        return response;
    }

    public ResponseEntity<String> get_products(int num_to_find){
        Page<Product> products = product_repo.findAll(PageRequest.of(0, num_to_find, Sort.by(Sort.Order.asc("id"))));
        ResponseEntity<String> response = new ResponseEntity<>(products.getContent().toString(), HttpStatus.OK);
        return response;
    }

    public ResponseEntity<String> delete_product(long product_id){
        product_repo.deleteById(product_id);
        ResponseEntity<String> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return response;
    }
}
