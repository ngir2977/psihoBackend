package com.example.licenta.repository;

import com.example.licenta.model.SoliciareAcord;
import com.example.licenta.model.StudentTeacherId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitareAcordRepository extends JpaRepository<SoliciareAcord, StudentTeacherId> {
}

