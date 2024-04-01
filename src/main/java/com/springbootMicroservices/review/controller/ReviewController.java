package com.springbootMicroservices.review.controller;

import com.springbootMicroservices.review.domain.Review;
import com.springbootMicroservices.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviewByCompanyId(@PathVariable("companyId") long id) {

        return new ResponseEntity<>();
    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> createReviewByCompanyId(@PathVariable("companyId") long id,
                                                          @RequestBody Review review) {

        return new ResponseEntity<>();
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewByReviewId(@PathVariable("companyId") long companyId,
                                                      @PathVariable("reviewId") long reviewId) {

        return new ResponseEntity<>();
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<List<Review>> updateReviewByReviewId() {

        return new ResponseEntity<>();
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviewByCompanyId() {

        return new ResponseEntity<>();
    }

}
