package com.gabrielgodoi.course.config;

import com.gabrielgodoi.course.entities.User;
import com.gabrielgodoi.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9823107", "123");
        User u2 = new User(null, "Alex Green", "Alexa@gmail.com", "2432432", "123");

        this.userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
