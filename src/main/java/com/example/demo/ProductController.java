package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductController {
String s="narendra";
int i=10;
	@Autowired
	private ProductRepository repo;
	@PostMapping(value="/product",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveProduct(@RequestBody Product p){
		repo.save(p);
		
		
		return new ResponseEntity<String>("product saved",HttpStatus.CREATED);
		
	}
	@GetMapping(value="/products",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProduct(){
		List<Product> findAll = repo.findAll();
		
		
		return new ResponseEntity<>(findAll,HttpStatus.OK);
		
	}

}
