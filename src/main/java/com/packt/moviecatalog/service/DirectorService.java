package com.packt.moviecatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.moviecatalog.domain.Director;
import com.packt.moviecatalog.domain.DirectorRepository;
import org.springframework.data.domain.Sort;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public Iterable<Director> findAllDirectorsSorted() {

        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return directorRepository.findAll(sort);

    }
    
}
