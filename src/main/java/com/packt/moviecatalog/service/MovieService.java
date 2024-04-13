package com.packt.moviecatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.packt.moviecatalog.domain.Movie;
import com.packt.moviecatalog.domain.MovieRepository;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;

    public Iterable<Movie> findAllMoviesSorted() {

        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        return movieRepository.findAll(sort);

    }

}
