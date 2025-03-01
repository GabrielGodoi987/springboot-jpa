package com.gabrielgodoi.course.repositories;

import com.gabrielgodoi.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
