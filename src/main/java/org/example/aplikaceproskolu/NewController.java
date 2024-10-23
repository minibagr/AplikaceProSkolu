package org.example.aplikaceproskolu;

import org.example.aplikaceproskolu.objekty.User;
import org.example.aplikaceproskolu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;
import java.util.UUID;

@Controller
public class NewController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/account/{id}")
    public String getUserById(@PathVariable() UUID id, Model model) {
        model.addAttribute(userRepo.findById(id).orElse(null));
        return "account";
    }

    @GetMapping("/problemy")
    public String problemy() {
        return "problemy";
    }

    @GetMapping("/problem-add")
    public String problemAdd() {
        return "problem-add";
    }

    @GetMapping("/problem/{id}")
    public String problem(@PathVariable UUID problemUUID, Model model) {
        return "problem";
    }
}
