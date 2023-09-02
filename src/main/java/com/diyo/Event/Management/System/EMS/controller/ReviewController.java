package com.diyo.Event.Management.System.EMS.controller;

import com.diyo.Event.Management.System.EMS.entity.Reviews;
import com.diyo.Event.Management.System.EMS.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin("http://localhost:4200")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/comment")
    public ResponseEntity<String>postComment(@RequestBody Reviews reviews){
        return ResponseEntity.ok(reviewService.postComment(reviews));
    }

    @GetMapping("/comment")
    public ResponseEntity<List<Reviews>>getComment(){
        return ResponseEntity.ok(reviewService.getComment());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteComment(@PathVariable("id") Long id){
        return ResponseEntity.ok(reviewService.deleteComment(id));
    }
}
