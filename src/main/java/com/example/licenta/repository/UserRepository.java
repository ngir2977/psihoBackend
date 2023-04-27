package com.example.licenta.repository;

import com.example.licenta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

        public User findUserByEmailAndPassword(String email,String password);

        public User findUserByEmail(String email);


        //public User addUser(String username, String email, String password);
}
