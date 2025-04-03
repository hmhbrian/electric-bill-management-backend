package com.example.demo.controller;

import com.example.demo.Service.FeedbackService;
import com.example.demo.entity.Customer;
import com.example.demo.entity.electric_bill;
import com.example.demo.entity.feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<feedback> addFeedback(@RequestBody feedback feedback) {
        try {
            feedback createdFeedback = feedbackService.saveFeedback(feedback);;
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedback);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<feedback>> getAllFeedbacks() {
        List<feedback> feedbacks = feedbackService.getAllFeedbacksSortedByDate();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }
}
