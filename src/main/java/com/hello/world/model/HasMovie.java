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

    private Integer userRating;
    private String status;

    public HasMovie() {}

    public HasMovie(String uid, Integer mid, Integer userRating, String status) {
        this.uid = uid;
        this.mid = mid;
        this.userRating = userRating;
        this.status = status;
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

    public Integer getUserRating() {
        return userRating;
    }

    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
