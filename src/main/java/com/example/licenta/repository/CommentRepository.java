package com.example.licenta.repository;

import com.example.licenta.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment,Integer> {

    List<Comment>  findAllByChapterId(Integer chapterId);
}
