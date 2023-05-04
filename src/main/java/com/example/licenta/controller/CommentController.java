package com.example.licenta.controller;

import com.example.licenta.model.Comment;
import com.example.licenta.model.CommentsByChapter;
import com.example.licenta.model.User;
import com.example.licenta.service.CommentService;
import com.example.licenta.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("comments")
@CrossOrigin(origins = "*")
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping(value = "/getCommentsByChapter/")
        public ResponseEntity<?> findAllByNameChapter(@RequestBody CommentsByChapter chapter) {
            System.out.println(chapter.getChapter());
            ArrayList<Comment> comments = commentService.findAllByNameChapter(chapter.getChapter());
            if (comments.size() == 0)
                return new ResponseEntity<>("No comments for this chapter!", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        Comment commentObj = commentService.save(comment);
        if(commentObj != null) {
            return new ResponseEntity<>(commentObj, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
