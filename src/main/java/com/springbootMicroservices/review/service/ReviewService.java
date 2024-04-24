package com.springbootMicroservices.review.service;

import com.springbootMicroservices.review.domain.Review;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview(long id);
    boolean addReview(long companyId, @RequestBody Review review);
    Review getReview(long companyId, long reviewId);
    Boolean updateReview(long companyId, long reviewId, @RequestBody Review review);
    Boolean deleteReview(long reviewId, long companyId);
}
