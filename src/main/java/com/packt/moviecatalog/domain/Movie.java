package com.packt.moviecatalog.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long movieid;

    private String title;
    private int releaseYear;
    private String genre;
    private int length;

    @ManyToOne
    @JoinColumn(name="directorid")
    private Director director;

    @JsonIgnoreProperties("movie")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="movie")
    private List<Review> reviews;

    public Movie() {}

    public Movie(String title, int releaseYear, String genre, int length, Director director) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.length = length;
        this.director = director;
    }

    public long getMovieid() {
        return movieid;
    }

    public void setMovieid(long movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}