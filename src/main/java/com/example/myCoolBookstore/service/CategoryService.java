package com.example.myCoolBookstore.service;

import org.springframework.stereotype.Service;
import com.example.myCoolBookstore.entity.Category;
import com.example.myCoolBookstore.repo.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }
}
