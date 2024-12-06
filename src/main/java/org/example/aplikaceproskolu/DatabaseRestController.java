package org.example.aplikaceproskolu;

import jakarta.servlet.http.HttpServletResponse;
import org.example.aplikaceproskolu.objekty.ClassRoom;
import org.example.aplikaceproskolu.objekty.Problem;
import org.example.aplikaceproskolu.objekty.UserPrincipal;
import org.example.aplikaceproskolu.objekty.Users;
import org.example.aplikaceproskolu.repo.ClassRoomRepo;
import org.example.aplikaceproskolu.repo.ProblemRepo;
import org.example.aplikaceproskolu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


@RestController
public class DatabaseRestController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProblemRepo problemRepo;
    @Autowired
    ClassRoomRepo classRepo;

    @PostMapping("/api/problem-add")
    public void addProblem(@ModelAttribute("problem") Problem problem, HttpServletResponse httpResponse) throws IOException {
        System.out.println("Post: " + problem.getUserId());
        problem.setCreated(new Date());
        problemRepo.save(problem);
        httpResponse.sendRedirect("/");
    }

    @GetMapping("/api/users")
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/api/test")
    public String test() {
//        return userRepo.currentUser();
        return "test";
    }

    @GetMapping("/api/classes")
    public List<ClassRoom> classes() {
        return classRepo.findAll();
    }

    @PostMapping("/api/create-classes")
    public void createClasses(@RequestBody Map<Integer, String> payload) {
        for (String obj : payload.values()) {
            System.out.println(obj);
            ClassRoom classRoom = new ClassRoom();
            classRoom.setName(obj);
            classRepo.save(classRoom);
        }
    }

    @GetMapping("/api/account/{id}")
    public String getUserById(@PathVariable() UUID id, Model model) {
        model.addAttribute(Objects.requireNonNull(userRepo.findById(id).orElse(null)));
        return "account";
    }
}
