package com.example.demo.repository;

import com.example.demo.entity.electric_bill;
import com.example.demo.entity.feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<feedback, Integer> {
    @Query("SELECT fb FROM feedback fb ORDER BY fb.FEEDBACK_DATE desc")
    List<feedback> findAllByOrderByFEEDBACK_DATEDesc();
}
