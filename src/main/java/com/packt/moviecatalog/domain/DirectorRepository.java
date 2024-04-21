package com.packt.moviecatalog.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {

    List<Director> findByName(String name);

    List<Director> findByNameContainingIgnoreCase(String name);
    
}
