package com.imemyself.course.service;

import java.util.List;
import java.util.Optional;

import com.imemyself.course.domain.Order;
import com.imemyself.course.domain.Order;
import com.imemyself.course.repository.OrderRepository;
import com.imemyself.course.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository serviceRepository;

    public List<Order> findAll() {
        return serviceRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = serviceRepository.findById(id);
        return obj.get();
    }

}
