package com.hello.world.repository;

import com.hello.world.model.ValidMovieId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ValidMovieIdRepository extends JpaRepository<ValidMovieId, Integer> {
    @Query(value = "select id from valid_movie_id order by RAND() LIMIT 1", nativeQuery = true)
    ValidMovieId getRandomMovieId();
}
