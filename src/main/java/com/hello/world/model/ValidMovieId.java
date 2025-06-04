package com.hello.world.model;


import com.hello.world.CompositePK.HasMoviePK;
import jakarta.persistence.*;

@Entity
@Table(name = "has_movie")
public class ValidMovieId {

    @Id
    @Column(nullable = false)
    private String id;

    public ValidMovieId() {}

    public ValidMovieId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
