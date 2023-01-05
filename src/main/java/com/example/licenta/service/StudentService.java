package com.example.licenta.service;

import com.example.licenta.exceptions.RequestsLimitReachedException;
import com.example.licenta.model.SoliciareAcord;
import com.example.licenta.model.StudentTeacherId;
import com.example.licenta.repository.*;
import com.example.licenta.requests.SolicitareAcordRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class StudentService {
    @Resource
    AcordRepository acordRepository;
    @Resource
    CoordonationRepository coordonationRepository;
    @Resource
    TeacherRepository teacherRepository;
    @Resource
    UserRepository userRepository;

    @Resource
    SolicitareAcordRepository solicitareAcordRepository;

    public void sendRequest(SolicitareAcordRequest solicitareAcordRequest) throws RequestsLimitReachedException {
        Long countOfRequestsMade = solicitareAcordRepository
                .findAll()
                .stream()
                .filter(x -> x.getTime().isAfter(LocalDateTime.now().minusWeeks(1))
                        &&
                        x.getId().getStudentId() == solicitareAcordRequest.getStudentId())
                .count();

        if(countOfRequestsMade >= 3) {
            throw new RequestsLimitReachedException("This student has already made 3 requests this week.");
        }

        StudentTeacherId studentTeacherId = new StudentTeacherId(solicitareAcordRequest.getStudentId(), solicitareAcordRequest.getTeacherId());
        String fileURL = solicitareAcordRequest.getFileURL();
        solicitareAcordRepository.save(new SoliciareAcord(studentTeacherId, fileURL, LocalDateTime.now()));
    }
}
