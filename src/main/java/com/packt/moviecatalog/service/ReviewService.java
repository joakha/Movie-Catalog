package com.packt.moviecatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.packt.moviecatalog.domain.Review;
import com.packt.moviecatalog.domain.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Iterable<Review> findAllReviewsSorted() {

        Sort sort = Sort.by(Sort.Direction.DESC, "score");
        return reviewRepository.findAll(sort);

    }
    
}
