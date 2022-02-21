package com.imemyself.course.service;

import java.util.List;
import java.util.Optional;

import com.imemyself.course.domain.User;
import com.imemyself.course.exception.ResourceNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return serviceRepository.save(obj);
    }

    public void delete(Long id) {
        serviceRepository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = serviceRepository.getOne(id);
        updateData(entity, obj);
        return serviceRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
