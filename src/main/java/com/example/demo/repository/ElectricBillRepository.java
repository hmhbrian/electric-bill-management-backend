package com.example.demo.repository;

import com.example.demo.entity.electric_bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectricBillRepository extends JpaRepository<electric_bill, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE electric_bill eb SET eb.LATE_FEE = eb.TOTAL_AMOUNT * 0.05, eb.IS_PAID = 2 " +
            "WHERE eb.DUE_DATE < CURRENT_DATE AND eb.IS_PAID = 0")
    int updateLateFeeAndStatus();


    @Query("SELECT eb FROM electric_bill eb WHERE eb.CUSTOMER_ID = :customerId AND eb.IS_PAID = 2")
    List<electric_bill> findOverdueBillsByCustomerId(@Param("customerId") long customerId);

    Optional<electric_bill> findById(int id);
}
