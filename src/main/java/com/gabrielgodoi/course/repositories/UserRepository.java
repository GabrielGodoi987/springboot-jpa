package com.gabrielgodoi.course.repositories;

import com.gabrielgodoi.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// não precisa criar implementação para esta interface, pois o jpa repository já faz isso pra nós
public interface UserRepository extends JpaRepository<User, Long> {
}
