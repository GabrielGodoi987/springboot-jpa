package com.gabrielgodoi.course.resources;

import com.gabrielgodoi.course.entities.Product;
import com.gabrielgodoi.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = this.productService.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findOne(@PathVariable  Long id) {
        Product product = this.productService.findOne(id);
        return ResponseEntity.ok().body(product);
    }
}
