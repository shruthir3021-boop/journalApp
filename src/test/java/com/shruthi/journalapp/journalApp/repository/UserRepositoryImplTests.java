package com.shruthi.journalapp.journalApp.repository;

import com.mongodb.assertions.Assertions;
import com.shruthi.journalapp.repository.UserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTests {





        @Autowired
        private UserRepositoryImpl userRepository ;

        @Test
        public void testSaveNewUser() {
            Assertions.assertNotNull(userRepository.getUsersForSA());


        }

    }



