package com.packt.moviecatalog.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long reviewid;

    @Min(0)
    private double score;

    @NotBlank(message = "This field should not be empty")
    private String comment;

    @ManyToOne
    @JoinColumn(name="movieid")
    private Movie movie;

    public Review() {}

    public Review(double score, String comment, Movie movie) {
        this.score = score;
        this.comment = comment;
        this.movie = movie;
    }

    public long getReviewid() {
        return reviewid;
    }

    public void setReviewid(long reviewid) {
        this.reviewid = reviewid;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}