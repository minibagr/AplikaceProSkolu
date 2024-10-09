package org.example.aplikaceproskolu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class NewController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable UUID teacherUUID, Model model) {
        return "profile";
    }

    @GetMapping("/problemy")
    public String problemy() {
        return "problemy";
    }

    @GetMapping("/problem/{id}")
    public String problem(@PathVariable UUID problemUUID, Model model) {
        return "problem";
    }
}
