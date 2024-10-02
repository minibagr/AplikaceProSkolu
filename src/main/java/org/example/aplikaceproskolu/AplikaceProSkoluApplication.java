package org.example.aplikaceproskolu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class AplikaceProSkoluApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplikaceProSkoluApplication.class, args);
	}

	@GetMapping("/")
	String profile() {
		return "profile.html";
	}

}
