package com.shruthi.journalapp.journalApp.service;

import com.shruthi.journalapp.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    void testSendEmail(){
        emailService.sendEmail("shruthi.r3021@gmail.com","Testing Java mail sender", "HI thre?");
    }
}
