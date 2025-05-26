package com.hello.world.service;

import com.hello.world.model.HasMovie;
import com.hello.world.repository.HasMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class HasMovieService {
    private final HasMovieRepository hasMovieRepository;

    @Autowired
    public HasMovieService(HasMovieRepository hasMovieRepository) {
        this.hasMovieRepository = hasMovieRepository;
    }

    public List<HasMovie> createHasMovie() {
        return hasMovieRepository.findAll();
    }
}
