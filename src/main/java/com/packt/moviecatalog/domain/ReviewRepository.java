package com.packt.moviecatalog.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findByScore(@Param("score") double score);
    
}
