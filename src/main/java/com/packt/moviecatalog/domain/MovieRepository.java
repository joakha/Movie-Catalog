package com.packt.moviecatalog.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findByTitle(@Param("title") String title);

    List<Movie> findByGenre(@Param("genre") String genre);
    
}
