package org.example.aplikaceproskolu;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.transaction.Transactional;
import org.example.aplikaceproskolu.objekty.ClassRoom;
import org.example.aplikaceproskolu.objekty.Problem;
import org.example.aplikaceproskolu.objekty.User;
import org.example.aplikaceproskolu.repo.ClassRoomRepo;
import org.example.aplikaceproskolu.repo.ProblemRepo;
import org.example.aplikaceproskolu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
public class DatabaseRestController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProblemRepo problemRepo;
    @Autowired
    ClassRoomRepo classRepo;

    @PostMapping("/user")
    public User newUser(@RequestBody User user) {
        userRepo.save(user);
        return user;
    }

    @PostMapping("/problem-add")
    public Problem addProblem(@RequestBody Map<String, Object> payload) {
        Problem problem = new Problem();
        ClassRoom classRoom = classRepo.findByName(payload.get("classId").toString());

        problem.name = (String) payload.get("name");
        problem.comment = (String) payload.get("comment");
        problem.classId = classRoom;
        problem.created = new Date();

        return problemRepo.save(problem);
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

    @GetMapping("/classes")
    public List<ClassRoom> classes() {
        return classRepo.findAll();
    }

    @PostMapping("/create-classes")
    public void createClasses(@RequestBody Map<Integer, String> payload) {
        for (String obj : payload.values()) {
            System.out.println(obj);
            ClassRoom classRoom = new ClassRoom();
            classRoom.name = obj;
            classRepo.save(classRoom);
        }
    }
}
