package com.example.licenta.repository;

import com.example.licenta.model.Comment;
import com.example.licenta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment,Integer> {

    public ArrayList<Comment>  findAllByChapter (String chapter);
}
