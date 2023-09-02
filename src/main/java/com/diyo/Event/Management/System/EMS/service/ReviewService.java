package com.diyo.Event.Management.System.EMS.service;

import com.diyo.Event.Management.System.EMS.entity.Reviews;
import com.diyo.Event.Management.System.EMS.repository.ReviewRepository;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public String postComment(Reviews reviews) {
        reviewRepository.save(reviews);
        return "Comment saved successfully.";
    }

    public List<Reviews> getComment() {
        return reviewRepository.findAll();
    }

    public String deleteComment(Long id) {
        Optional<Reviews>reviewsOptional = reviewRepository.findById(id);
        if (reviewsOptional.isPresent()){
            reviewRepository.deleteById(id);
            return "Comment deleted successfully";
        }
        else{
            return "Comment not found";
        }
    }
}
