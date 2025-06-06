package com.hello.world.controller;

import com.hello.world.CompositePK.HasMoviePK;
import com.hello.world.model.*;
import com.hello.world.repository.*;
import com.hello.world.service.HasMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    HasMovieRepository hasMovieRepository;

    @Autowired
    ValidMovieIdRepository validMovieIdRepository;

    @GetMapping(path="/api/hello")
    public HashMap<String, String> sayHello() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "hello");
        return map;
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

    Boolean createUser(User user) {
        try {
            User dest =  userRepository.saveAndFlush(user);
            return true;
        } catch (Exception e) {
            //throw new RuntimeException(e);
            return false;
        }
    }

    Boolean createMovie(Movie movie) {
        try {
            Movie dest = movieRepository.saveAndFlush(movie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    Boolean doesUserExist(String id) {
        return userRepository.existsById(id);
    }

    Boolean doesMovieExist(Integer id) {
        return movieRepository.existsById(id);
    }

    @GetMapping(path = "/getHasMovie/{uid}")
    ResponseEntity<List<HasMovie>> getHasMovie(@PathVariable("uid") String uid) {
        try {
            List<HasMovie> dest = hasMovieRepository.getAllMoviesForUser(uid);
            return new ResponseEntity<>(dest, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/getHasMoviePopulated/{uid}")
    ResponseEntity<List<Object>> getHasMoviePopulated(@PathVariable("uid") String uid) {
        try {
            List<Object> dest = hasMovieRepository.getAllMoviesForUserPopulatedAndSorted(uid);
            return new ResponseEntity<>(dest, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/addToList", consumes = {"application/json"})
    ResponseEntity<HasMovie> createHasMovieEntry(@RequestBody ListPayload listPayload) {
        //Does user exist
        //If not create user
        if (!doesUserExist(listPayload.getUid())) {
            String uid = listPayload.getUid();
            User user = new User(uid);
            boolean result = createUser(user);
            if (result == false) {
                return new ResponseEntity<HasMovie>(HttpStatus.BAD_REQUEST);
            }
        }
        //Does movie exist
        //If not create movie
        if (!doesMovieExist(listPayload.getMid())) {
            Integer mid = listPayload.getMid();
            String poster_path = listPayload.getPoster_path();
            String title = listPayload.getTitle();
            BigDecimal rating = listPayload.getRating();
            Integer votes = listPayload.getVotes();
            LocalDate release_date = listPayload.getRelease_date();
            Movie movie = new Movie(mid, poster_path, title, rating, votes, release_date);
            boolean result = createMovie(movie);
            if (result == false) {
                return new ResponseEntity<HasMovie>(HttpStatus.BAD_REQUEST);
            }
        }
        //Now create hasMovieEntry
        String uid = listPayload.getUid();
        Integer mid = listPayload.getMid();
        Integer user_rating = listPayload.getUser_rating();
        String movie_status = listPayload.getMovie_status();

        HasMovie hasMovie = new HasMovie(uid, mid, user_rating,movie_status);
        try {
            HasMovie dest = hasMovieRepository.saveAndFlush(hasMovie);
            return new ResponseEntity<>(dest, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }



    @GetMapping(path="/getRandomMovieID")
    public ResponseEntity<ValidMovieId> getRandomMovieID() {
        try {
            ValidMovieId dest = validMovieIdRepository.getRandomMovieId();
            return new ResponseEntity<>(dest, HttpStatus.OK);
        }
       catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @PostMapping(path="/deleteFromUserList", produces = "application/json")
    public ResponseEntity<Boolean> deleteFromList(@RequestBody HasMovie pHasMovie) {
        try {
            HasMoviePK hasMoviePK = new HasMoviePK(pHasMovie.getUid(), pHasMovie.getMid());
            Optional<HasMovie> dest = hasMovieRepository.findById(hasMoviePK);
            //Check if it exists
            if (dest.isEmpty()) {
                return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
            }
            hasMovieRepository.delete(dest.get());
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }


}





