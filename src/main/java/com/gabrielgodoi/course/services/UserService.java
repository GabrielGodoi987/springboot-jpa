package com.gabrielgodoi.course.services;

import com.gabrielgodoi.course.entities.User;
import com.gabrielgodoi.course.exceptions.ResourceNotFoundException;
import com.gabrielgodoi.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        this.userRepository.deleteById(id);
    }

    public User update(Long id, User user){
        // esse método apenas monitora um objeto do banco de dados -> preparando o objeto para que possamos realizar operações com esse objeto no banco de dados
        User entity = this.userRepository.getReferenceById(id);
        updateData(entity, user);
        return this.userRepository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
