package com.hello.world.repository;

import com.hello.world.CompositePK.HasMoviePK;
import com.hello.world.model.HasMovie;
import com.hello.world.model.HasMovieAndMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HasMovieRepository extends JpaRepository<HasMovie, HasMoviePK> {
    @Query(value = "Select * FROM has_movie WHERE uid = :uid", nativeQuery = true)
    List<HasMovie> getAllMoviesForUser(@Param("uid") String uid);

    @Query(value = "SELECT h.uid, h.mid, h.user_rating, h.movie_status, m.poster_path, m.title, m.rating, m.votes, m.release_date FROM has_movie h JOIN movie m ON h.mid = m.mid WHERE uid = :uid ORDER BY movie_status", nativeQuery = true)
    List<Object> getAllMoviesForUserPopulatedAndSorted(@Param("uid") String uid);
}
