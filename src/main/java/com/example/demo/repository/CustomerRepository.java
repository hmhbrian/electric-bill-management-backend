package com.example.demo.repository;


import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findById(Long id);
    @Query("SELECT c FROM Customer c WHERE LOWER(c.NAME) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Customer> searchCustomersByName(@Param("keyword") String keyword);

    @Query("SELECT c FROM Customer c WHERE c.ID_USER = :idUser")
    Optional<Customer> findByIdUser(@Param("idUser") int idUser);
}
