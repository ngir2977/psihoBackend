package com.example.licenta.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.example.licenta.model.User;
import com.example.licenta.service.EmailService;
import com.example.licenta.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ScheduledEmails {

    @Resource
    private EmailService emailService;

    @Resource
    private UserService userService;

    private List<String> citate = Arrays.asList("Anything worth doing well is worth doing poorly at first.",
            "Creativity is seeing what others see and thinking what no one else ever thought.",
            "Anyone who stops learning is old, whether at twenty or eighty.",
            "Be an innovator, not an imitator.",
            "Create with the heart; build with the mind.",
            "Creativity is thinking up new things. Innovation is doing new things.",
            "Don’t wait for inspiration. It comes while working",
            "Innovation survives only when people believe in their own ideas.",
            "Tell me and I forget, teach me and I may remember, involve me and I learn.",
            "The beautiful thing about learning is that nobody can take it away from you.",
            "The more that you read, the more things you will know. The more that you learn, the more places you'll go.",
            "The value of an idea lies in the using of it.",
            "The worst enemy to creativity is self-doubt.",
            "If you have knowledge, let others light their candles at it.",
            "Knowledge is the antidote to fear.");

    private String subject = "Hai la invatare!";

    private String getRandomMessage(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(citate.size());
        String citat = citate.get(randomNumber);
        return citat;
    }

    // fixedRate for 3 days: fixedRate = 259200000
    @Scheduled(fixedRate = 300000, initialDelay = 10000) // fixed rate 5 mins, initial delay 10 seconds
    public void sendEmailEveryThreeDays() {
        String message = getRandomMessage();

        List<User> users = userService.findAll();
        for (User user : users){
            String email = user.getEmail();
            emailService.sendSimpleMessage(email, subject, message);
        }
    }
}