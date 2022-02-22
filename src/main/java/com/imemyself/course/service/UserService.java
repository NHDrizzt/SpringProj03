package com.imemyself.course.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.imemyself.course.domain.User;
import com.imemyself.course.exception.DatabaseException;
import com.imemyself.course.exception.ResourceNotFoundException;
import com.imemyself.course.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            serviceRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) {
        try {
            User entity = serviceRepository.getOne(id);
            updateData(entity, obj);
            return serviceRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
