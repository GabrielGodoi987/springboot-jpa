package com.gabrielgodoi.course.services;

import com.gabrielgodoi.course.entities.User;
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
        return user.get();
    }

    public User insert(User user){
        return this.userRepository.save(user);
    }
}
