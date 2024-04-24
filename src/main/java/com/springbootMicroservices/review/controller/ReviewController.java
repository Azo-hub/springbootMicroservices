package com.springbootMicroservices.review.controller;

import com.springbootMicroservices.review.domain.Review;
import com.springbootMicroservices.review.repository.ReviewRepository;
import com.springbootMicroservices.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(@PathVariable("companyId") long id) {

        return new ResponseEntity<>(reviewService.getAllReview(id), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable("companyId") long id, @RequestBody Review review) {
        boolean reviewCreated = reviewService.addReview(id, review);
        if(reviewCreated){
            return new ResponseEntity<>("Review added Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to add a new review", HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable("companyId") long companyId,
                                                      @PathVariable("reviewId") long reviewId) {

        return new ResponseEntity<>(reviewService.getReview(companyId,reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable("companyId") long companyId,
                               @PathVariable("reviewId") long reviewId, @RequestBody Review review) {
        Boolean updated = reviewService.updateReview(companyId, reviewId, review);
        if(updated){
            return new ResponseEntity<>("updated successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable("reviewId") long reviewId,
                                               @PathVariable("companyId") long companyId) {
        boolean deleted = reviewService.deleteReview(reviewId, companyId);
        if(deleted){
            return new ResponseEntity<>("Review successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not successfully deleted", HttpStatus.BAD_REQUEST);
    }

}
