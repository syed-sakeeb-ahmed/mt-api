package com.hello.world.controller;

import com.hello.world.model.HasMovie;
import com.hello.world.model.Movie;
import com.hello.world.model.TestTable;
import com.hello.world.model.User;
import com.hello.world.repository.HasMovieRepository;
import com.hello.world.repository.MovieRepository;
import com.hello.world.repository.TestRepository;
import com.hello.world.repository.UserRepository;
import com.hello.world.service.HasMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    /*
    Notes:

    TestTable object is converted to test_table when trying to actually
    connect to the mySQL db.

    Model objects must have empty constructor, generic constructor,
    getter and setter functions to work correctly
     */

//    @Autowired
//    TestRepository testRepo;

    HasMovieService hasMovieService;

    @Autowired
    public ApiController(HasMovieService hasMovieService) {
        this.hasMovieService = hasMovieService;
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;

    @GetMapping(path="/api/hello")
    @CrossOrigin(origins = "http://localhost:5173")
    public String sayHello() {
        return "Hello";
    }

//    @PostMapping(path = "/insert", consumes = "application/json")
//    public TestTable addTestTable(@RequestBody TestTable testTable) {
//        TestTable dest = testRepo.saveAndFlush(testTable);
//        return dest;
//    }

//    @PostMapping(path = "/test", consumes = "application/json")
//    public TestTable returnTestTable(@RequestBody TestTable testTable) {
//
//        return testTable;
//    }

    @PostMapping(path = "/addToList", consumes = "application/json")
    List<HasMovie> search() {
        return hasMovieService.createHasMovie();
    }

    @PostMapping(path = "/createUser", consumes = "application/json")
    User createUser(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }

    @PostMapping(path = "/createMovie", consumes = "application/json")
    Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }
}





