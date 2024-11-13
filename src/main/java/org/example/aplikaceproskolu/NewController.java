package org.example.aplikaceproskolu;

import org.example.aplikaceproskolu.objekty.Problem;
import org.example.aplikaceproskolu.repo.ClassRoomRepo;
import org.example.aplikaceproskolu.repo.ProblemRepo;
import org.example.aplikaceproskolu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@Controller
public class NewController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ClassRoomRepo classroomRepo;
    @Autowired
    private ProblemRepo problemRepo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("problems", problemRepo.findAll());
        return "index";
    }

    @GetMapping("/account/{token}")
    public String getUserById(@PathVariable() UUID token, Model model) {
        model.addAttribute(userRepo.findByToken(token));
        return "account";
    }

    @GetMapping("/problemy")
    public String problemy() {
        return "problemy";
    }

    @GetMapping("/problem-add")
    public String problemAdd(Model model) {
        model.addAttribute("classes", classroomRepo.findAll());
        model.addAttribute("problem", new Problem());
        return "problem-add";
    }

    @GetMapping("/problem/{id}")
    public String problem(@PathVariable UUID problemUUID, Model model) {
        return "problem";
    }
}
