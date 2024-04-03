package com.springbootMicroservices.review.service.impl;

import com.springbootMicroservices.company.domain.Company;
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
        return reviewRepository.findByCompany(id);
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
        List<Review> reviews = reviewRepository.findByCompany(companyId);
        return reviews.stream().filter(review -> review.getId() == reviewId).findFirst().orElse(null);
    }

    @Override
    public Review updateReview(long companyId, long reviewId, Review review) {
        if(companyRepository.findById(companyId).isPresent()
                && reviewRepository.findById(reviewId).isPresent()) {
            review.setCompany(companyRepository.findById(companyId).orElse(null));
            reviewRepository.save(review);

            return review;
        }
        return null;
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
