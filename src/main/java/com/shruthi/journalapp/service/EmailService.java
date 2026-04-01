package com.shruthi.journalapp.service;
import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class EmailService {






        @Autowired
        private JavaMailSender javaMailSender;

        public void sendEmail(String to, String subject, String body){
            log.info("Attempting mail",to);
            try{
                SimpleMailMessage mail= new SimpleMailMessage();
                mail.setTo(to);
                mail.setSubject(subject);
                mail.setText(body);
                javaMailSender.send(mail);
                log.info("email sent successfully");
               } catch (Exception e) {

                log.error("Exception while sendEmail", e);
            }

    }

    }

