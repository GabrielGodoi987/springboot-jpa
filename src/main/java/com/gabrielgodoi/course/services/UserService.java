package com.gabrielgodoi.course.services;

import com.gabrielgodoi.course.entities.User;
import com.gabrielgodoi.course.exceptions.DatabaseException;
import com.gabrielgodoi.course.exceptions.ResourceNotFoundException;
import com.gabrielgodoi.course.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findOne(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return this.userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            this.userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        // esse método apenas monitora um objeto do banco de dados -> preparando o objeto para que possamos realizar operações com esse objeto no banco de dados
        try{
            User entity = this.userRepository.getReferenceById(id);
            updateData(entity, user);
            return this.userRepository.save(entity);
        } catch (EntityNotFoundException e) {
           throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
