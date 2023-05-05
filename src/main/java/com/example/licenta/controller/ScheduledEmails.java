package com.example.licenta.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ScheduledEmails {

    @Resource
    private EmailService emailService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // fixedRate = 5 seconds, initialDelay = 10 seconds
    @Scheduled(fixedRate = 5000, initialDelay = 10000)
    public void reportCurrentTime() {
//        System.out.println("Email sent now " + dateFormat.format(new Date()));
    }

    // fixedRate should be 3 days
    @Scheduled(fixedRate = 259200000, initialDelay = 10000) // initial delay 10 seconds
    public void sendEmailEveryThreeDays() {
        System.out.println("Real Email sent now " + dateFormat.format(new Date()));
        emailService.sendSimpleMessage("danieldragoi17@gmail.com", "Subiect motivational", "Motivatieeeeeeee!");
        emailService.sendSimpleMessage("gabriela_negrea15@yahoo.com", "Subiect motivational", "Motivatieeeeeeee!");
    }
}