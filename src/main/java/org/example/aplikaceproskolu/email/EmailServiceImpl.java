package org.example.aplikaceproskolu.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceImpl {
    @Autowired
    JavaMailSender mailSender;
}
