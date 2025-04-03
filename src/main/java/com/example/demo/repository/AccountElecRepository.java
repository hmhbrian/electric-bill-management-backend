package com.example.demo.repository;

import com.example.demo.entity.AccountElec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountElecRepository extends JpaRepository<AccountElec, Integer> {
    Optional<AccountElec> findByUSERNAME(String username);
    Optional<AccountElec> findByUSERNAMEAndPASS(String username, String password);
    @Query("SELECT a.ID_USER FROM AccountElec a WHERE a.USERNAME = :username")
    Integer findIdByUSERNAME(@Param("username") String username);
}
