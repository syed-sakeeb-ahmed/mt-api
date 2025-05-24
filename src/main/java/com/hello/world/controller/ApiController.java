package com.hello.world.controller;

import com.hello.world.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class ApiController {

//    @Autowired
//    TestRepository userRepo;

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public Data sayHello() {
        return new Data("Hello, World V11!", 42);
    }

//    public String addUser(String uid) {
//        userRepo.
//    }
}





