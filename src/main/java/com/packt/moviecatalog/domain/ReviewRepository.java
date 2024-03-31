package com.packt.moviecatalog.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findByScore(double score);
    
}
