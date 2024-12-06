package org.example.aplikaceproskolu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication()
public class AplikaceProSkoluApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplikaceProSkoluApplication.class, args);
	}
}
