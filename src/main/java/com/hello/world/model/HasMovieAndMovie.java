package com.hello.world.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HasMovieAndMovie {

    //HasMovie
    private String uid;
    private Integer mid;

    private Integer user_rating;
    private String movie_status;

    //Movie
    private String poster_path;
    private String title;
    private BigDecimal rating;
    private Integer votes;
    private LocalDate release_date;

    public HasMovieAndMovie() {}

    public HasMovieAndMovie(String uid, Integer mid, Integer user_rating, String movie_status, String poster_path, String title, BigDecimal rating, Integer votes, LocalDate release_date) {
        this.uid = uid;
        this.mid = mid;
        this.user_rating = user_rating;
        this.movie_status = movie_status;
        this.poster_path = poster_path;
        this.title = title;
        this.rating = rating;
        this.votes = votes;
        this.release_date = release_date;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(Integer user_rating) {
        this.user_rating = user_rating;
    }

    public String getMovie_status() {
        return movie_status;
    }

    public void setMovie_status(String movie_status) {
        this.movie_status = movie_status;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }
}
