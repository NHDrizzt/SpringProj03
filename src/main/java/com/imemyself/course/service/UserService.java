package com.imemyself.course.service;

import java.util.List;
import java.util.Optional;

import com.imemyself.course.domain.User;
import com.imemyself.course.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository serviceRepository;

    public List<User> findAll() {
        return serviceRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = serviceRepository.findById(id);
        return obj.get();
    }

    public User insert(User obj) {
        return serviceRepository.save(obj);
    }

    public void delete(Long id) {
        serviceRepository.deleteById(id);
    }

}
