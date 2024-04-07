package com.packt.moviecatalog.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DirectorRepository extends CrudRepository<Director, Long> {

    List<Director> findByName(@Param("name") String name);
    
}
