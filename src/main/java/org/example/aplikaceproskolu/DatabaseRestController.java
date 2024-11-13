package org.example.aplikaceproskolu;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.example.aplikaceproskolu.objekty.ClassRoom;
import org.example.aplikaceproskolu.objekty.Problem;
import org.example.aplikaceproskolu.objekty.User;
import org.example.aplikaceproskolu.repo.ClassRoomRepo;
import org.example.aplikaceproskolu.repo.ProblemRepo;
import org.example.aplikaceproskolu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public void addProblem(@ModelAttribute Problem problem, HttpServletResponse httpResponse) throws IOException {

        System.out.println(problem.getClassId());
        System.out.println(problem.getComment());

        problem.setCreated(new Date());
        problemRepo.save(problem);
        httpResponse.sendRedirect("/");
    }

    @GetMapping("api/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("api/test")
    public String test() {
//        return userRepo.currentUser();
        return "test";
    }

    @GetMapping("api/classes")
    public List<ClassRoom> classes() {
        return classRepo.findAll();
    }

    @PostMapping("api/create-classes")
    public void createClasses(@RequestBody Map<Integer, String> payload) {
        for (String obj : payload.values()) {
            System.out.println(obj);
            ClassRoom classRoom = new ClassRoom();
            classRoom.name = obj;
            classRepo.save(classRoom);
        }
    }

    @GetMapping("api/account/{id}")
    public String getUserById(@PathVariable() UUID id, Model model) {
        model.addAttribute(Objects.requireNonNull(userRepo.findById(id).orElse(null)));
        return "account";
    }
}
