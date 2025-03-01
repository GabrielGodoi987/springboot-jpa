package com.gabrielgodoi.course.config;

import com.gabrielgodoi.course.entities.Category;
import com.gabrielgodoi.course.entities.Order;
import com.gabrielgodoi.course.entities.User;
import com.gabrielgodoi.course.entities.enums.OrderStatus;
import com.gabrielgodoi.course.repositories.CategoryRepository;
import com.gabrielgodoi.course.repositories.OrderRepository;
import com.gabrielgodoi.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9823107", "123");
        User u2 = new User(null, "Alex Green", "Alexa@gmail.com", "2432432", "123");

        // letra z = o horário está no horário de greenwitch
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.userRepository.saveAll(Arrays.asList(u1, u2));
        this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
