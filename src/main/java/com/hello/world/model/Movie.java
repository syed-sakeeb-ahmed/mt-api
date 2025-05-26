package com.hello.world.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(nullable = false)
    private Integer mid;

    private String poster_path;
    private String title;
    private BigDecimal rating;
    private Integer votes;
    private LocalDate release_date;

    public Movie() {}

    public Movie(Integer mid, String poster_path, String title, BigDecimal rating, Integer votes, LocalDate release_date) {
        this.mid = mid;
        this.poster_path = poster_path;
        this.title = title;
        this.rating = rating;
        this.votes = votes;
        this.release_date = release_date;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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
