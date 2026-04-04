package com.shruthi.journalapp.controller;

import com.shruthi.journalapp.api.response.WeatherResponse;
import com.shruthi.journalapp.entity.JournalEntry;
import com.shruthi.journalapp.entity.User;
import com.shruthi.journalapp.repository.UserRepository;
import com.shruthi.journalapp.service.JournalEntryService;
import com.shruthi.journalapp.service.UserService;
import com.shruthi.journalapp.service.WeatherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.security.Security;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Tag(name =  "User APIs", description = "Read, Update & Delete User")
@Component public class UserController {

    @Autowired

    private WeatherService weatherService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAll();
//
//    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveNewUser(user);

    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        String greeting="";
        if(weatherResponse!=null)
            greeting= ".Weather feels like" + weatherResponse.getMain().getFeelsLike();

        return new ResponseEntity<>("Hi " +authentication.getName()+ greeting,HttpStatus.OK);
    }
}








