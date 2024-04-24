package com.springbootMicroservices.review.service.impl;

import com.springbootMicroservices.company.repository.CompanyRepository;
import com.springbootMicroservices.review.domain.Review;
import com.springbootMicroservices.review.repository.ReviewRepository;
import com.springbootMicroservices.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CompanyRepository companyRepository;

    
    @Override
    public List<Review> getAllReview(long id) {
        return reviewRepository.findByCompany(companyRepository.findById(id).orElse(null));
    }

    @Override
    public boolean addReview(long companyId, Review review) {
        if(companyRepository.findById(companyId).isPresent()) {
            review.setCompany(companyRepository.findById(companyId).orElse(null));
            reviewRepository.save(review);
            return true;
        };
        return false;
    }

    @Override
    public Review getReview(long companyId, long reviewId) {
        List<Review> reviews = reviewRepository.findByCompany(companyRepository.findById(companyId).orElse(null));
        return reviews.stream().filter(review -> review.getId() == reviewId).findFirst().orElse(null);
    }

    @Override
    public Boolean updateReview(long companyId, long reviewId, Review review) {
        if(companyRepository.findById(companyId).isPresent() &&
                reviewRepository.findById(reviewId).isPresent()){
                    reviewRepository.findById(reviewId).ifPresent(dbReview -> {
                        dbReview.setTitle(review.getTitle());
                        dbReview.setDescription(review.getDescription());
                        dbReview.setRating(review.getRating());
                        dbReview.setCompany(companyRepository.findById(companyId).orElse(null));
                        reviewRepository.save(dbReview);

            });
          return true;

        }

        return false;
    }

    @Override
    public Boolean deleteReview(long reviewId, long companyId) {
        if(companyRepository.findById(companyId).isPresent()
                && reviewRepository.findById(reviewId).isPresent()){
           // Review review = reviewRepository.findById(reviewId).orElse(null);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
