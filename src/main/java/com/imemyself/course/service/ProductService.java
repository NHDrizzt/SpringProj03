package com.imemyself.course.service;

import java.util.List;
import java.util.Optional;

import com.imemyself.course.domain.Product;
import com.imemyself.course.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository serviceRepository;

    public List<Product> findAll() {
        return serviceRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = serviceRepository.findById(id);
        return obj.get();
    }

}
