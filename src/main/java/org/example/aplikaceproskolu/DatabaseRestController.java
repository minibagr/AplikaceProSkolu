package org.example.aplikaceproskolu;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.transaction.Transactional;
import org.example.aplikaceproskolu.objekty.Problem;
import org.example.aplikaceproskolu.objekty.User;
import org.example.aplikaceproskolu.repo.ProblemRepo;
import org.example.aplikaceproskolu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DatabaseRestController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ProblemRepo problemRepo;

    @PostMapping("/user")
    public User newUser(@RequestBody User user) {
        userRepo.save(user);
        return user;
    }

    @PostMapping("/problem-add")
    public Problem addProblem(@RequestBody Problem problem) {
        problemRepo.save(problem);
        return problem;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/test")
    public String test() {
//        return userRepo.currentUser();
        return "test";
    }
}
