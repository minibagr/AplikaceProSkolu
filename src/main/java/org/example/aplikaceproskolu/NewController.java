package org.example.aplikaceproskolu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewController {

    @GetMapping("/")
    public String profile() {
        return "profile";
    }
}
