package com.hello.world.model;

import com.hello.world.CompositePK.HasMoviePK;
import jakarta.persistence.*;

@Entity
@IdClass(HasMoviePK.class)
@Table(name = "has_movie")
public class HasMovie {

    @Id
    @Column(nullable = false)
    private String uid;

    @Id
    @Column(nullable = false)
    private Integer mid;

    private Integer user_rating;
    private String movie_status;

    public HasMovie() {}

    public HasMovie(String uid, Integer mid, Integer user_rating, String movie_status) {
        this.uid = uid;
        this.mid = mid;
        this.user_rating = user_rating;
        this.movie_status = movie_status;
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
}
