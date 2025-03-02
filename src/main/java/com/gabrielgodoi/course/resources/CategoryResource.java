package com.gabrielgodoi.course.resources;

import com.gabrielgodoi.course.entities.Category;
import com.gabrielgodoi.course.entities.User;
import com.gabrielgodoi.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = this.categoryService.findAll();
        return ResponseEntity.ok().body(categories);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findOne(@PathVariable Long id) {
        Category category = this.categoryService.findOne(id);
        return ResponseEntity.ok().body(category);
    }
}
