package com.gabrielgodoi.course.services;

import com.gabrielgodoi.course.entities.Order;
import com.gabrielgodoi.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return this.orderRepository.findAll();
    }

    public Order findOne(Long id){
        Optional<Order> order = this.orderRepository.findById(id);

        return order.get();
    }
}
