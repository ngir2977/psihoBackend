package com.example.licenta.controller;

import com.example.licenta.model.*;
import com.example.licenta.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/findUser")
    public ResponseEntity<User> findUser(@RequestBody User user){
        User existingUser = userService.findUser(user);
        if(existingUser != null) {
            return new ResponseEntity<>(existingUser, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateProgress")
    public ResponseEntity<User> updateProgress(@RequestBody UpdateProgressObject updateProgressObject){
        User user = userService.updateProgress(updateProgressObject.getEmail(), updateProgressObject.getChapter());
        if(user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getUserProgress/{email}")
    public ResponseEntity<String> getUserProgress(@PathVariable String email){
        System.out.println(email);
        String progress = userService.getUserProgress(email);
        return new ResponseEntity<>(progress, HttpStatus.OK);
    }

    @PutMapping("/updateResults")
    public ResponseEntity<User> updateResults(@RequestBody UpdateResultsObject updateResultsObject){
        User user = userService.updateResults(updateResultsObject.getEmail(), updateResultsObject.getChapter(), updateResultsObject.getScore());
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getUserResults/{email}")
    public ResponseEntity<ArrayList<Result>> getUserResults(@PathVariable String email){
        System.out.println(email);
        ArrayList<Result> results = userService.getUserResults(email);
        return new ResponseEntity<ArrayList<Result>>(results, HttpStatus.OK);
}
    @GetMapping("/getUserTestResult/")
    public ResponseEntity<String> getUserTestResult(@RequestBody ResultTest testResultsObject){

        String result = userService.getUserResult(testResultsObject.getEmail(),testResultsObject.getChapter());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
