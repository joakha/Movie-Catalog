package com.packt.moviecatalog.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long directorid;

    @NotBlank(message = "This field should not be empty")
    private String name;

    @JsonIgnoreProperties("director")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="director")
    private List<Movie> movies;

    public Director() {}

    public Director(String name) {
        this.name = name;
    }

    public long getDirectorid() {
        return directorid;
    }

    public void setDirectorid(long directorid) {
        this.directorid = directorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
}