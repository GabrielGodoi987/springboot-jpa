package com.gabrielgodoi.course.services;

import com.gabrielgodoi.course.entities.Category;
import com.gabrielgodoi.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category findOne(Long id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        return category.get();
    }
}
