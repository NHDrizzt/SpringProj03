package com.imemyself.course.service;

import java.util.List;
import java.util.Optional;

import com.imemyself.course.domain.Category;
import com.imemyself.course.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository serviceRepository;

    public List<Category> findAll() {
        return serviceRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = serviceRepository.findById(id);
        return obj.get();
    }

}
