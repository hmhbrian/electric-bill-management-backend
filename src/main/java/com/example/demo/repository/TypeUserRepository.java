package com.example.demo.repository;
import com.example.demo.entity.Customer;
import com.example.demo.entity.electric_user_type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeUserRepository extends JpaRepository<electric_user_type, Integer> {
    Optional<electric_user_type> findById(Integer id);
}
