package com.gabrielgodoi.course.repositories;

import com.gabrielgodoi.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
