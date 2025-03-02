package com.gabrielgodoi.course.services;

import com.gabrielgodoi.course.entities.Product;
import com.gabrielgodoi.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findOne(Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        return product.get();
    }
}
