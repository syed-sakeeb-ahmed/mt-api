package com.hello.world.repository;

import com.hello.world.CompositePK.HasMoviePK;
import com.hello.world.model.HasMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HasMovieRepository extends JpaRepository<HasMovie, HasMoviePK> {

}
