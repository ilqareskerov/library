package com.company.library.service;

import com.company.library.model.Category;
import com.company.library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category loadCategory(Long id){
        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException());
    }

    public Category findByName(String value) {
        final Category category= categoryRepository.findByName(value).orElseThrow(()->new RuntimeException());
        return category;
    }
}
