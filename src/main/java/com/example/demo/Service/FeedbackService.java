package com.example.demo.Service;

import com.example.demo.entity.AccountElec;
import com.example.demo.entity.Customer;
import com.example.demo.entity.feedback;
import com.example.demo.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public feedback saveFeedback(feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<feedback> getAllFeedbacksSortedByDate() {
        List<feedback> fb = feedbackRepository.findAllByOrderByFEEDBACK_DATEDesc();

        return fb.stream().map(feedback -> new feedback(
                feedback.getID(),
                feedback.getSTAR(),
                feedback.getFEEDBACK_TEXT(),
                feedback.getFEEDBACK_DATE(),
                feedback.getCUSTOMER_ID()
        )).collect(Collectors.toList());
    }
}
