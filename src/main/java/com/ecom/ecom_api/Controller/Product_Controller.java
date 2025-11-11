package com.ecom.ecom_api.Controller;

import com.ecom.ecom_api.Objects.Models.Product;
import com.ecom.ecom_api.Objects.Request.New_Product;
import com.ecom.ecom_api.Service.Product_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class Product_Controller {

	@Autowired
	private Product_Service productService;

	// Create a new product
	@PostMapping("/add_product")
	public ResponseEntity<String> addProduct(@RequestBody New_Product product){
		return productService.add_product(product);
	}

	@PostMapping("/add_product_list")
	public ResponseEntity<String> addProductList(@RequestBody List<New_Product> product){
		return productService.add_product_list(product);
	}

	// Update an existing product
	@PutMapping("/update_product")
	public ResponseEntity<String> updateProduct(@RequestBody Product product){
		return productService.update_product(product);
	}

	// Get a single product by id
	@GetMapping("/get/{id}")
	public ResponseEntity<String> getProduct(@PathVariable("id") long id){
		return productService.get_product(id);
	}

	// Get multiple products with a limit
	@GetMapping("/get-multiple/{limit}")
	public ResponseEntity<String> getProducts(@RequestParam(name = "limit", defaultValue = "10") int limit){
		return productService.get_products(limit);
	}

	// Delete a product by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
		return productService.delete_product(id);
	}

	// TODO: endpoint for searching products by title or description
	// TODO: endpoint for advanced filtering (e.g., by category, price range) - will require products to be updated to have these fields
	// TODO: endpoint for bulk updates
	// TODO: endpoint for pruning duplicates
}
