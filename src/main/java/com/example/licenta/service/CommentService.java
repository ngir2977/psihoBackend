package com.example.licenta.service;

import com.example.licenta.model.Comment;
import com.example.licenta.model.User;
import com.example.licenta.repository.CommentRepository;
import com.example.licenta.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class CommentService{
    @Resource
    private CommentRepository commentRepository;

   public Comment save(Comment comment)
   {
       return commentRepository.save(comment);
   }

   public List<Comment> findAllByNameChapter(Integer chapterId)
   {

       return commentRepository.findAllByChapterId(chapterId);
   }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }


}
