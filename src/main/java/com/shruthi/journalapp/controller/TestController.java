package com.shruthi.journalapp.controller;

import com.shruthi.journalapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/email")
    public String testEmail() {
        emailService.sendEmail("shruthi.r3021@gmail.com", "Test", "Hello from Spring Boot");
        return "Email sent!";
    }
}

