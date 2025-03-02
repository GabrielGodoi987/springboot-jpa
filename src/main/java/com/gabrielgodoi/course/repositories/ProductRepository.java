package com.gabrielgodoi.course.repositories;

import com.gabrielgodoi.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
