package com.packt.moviecatalog.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findByScore(@Param("score") double score);
    
}
