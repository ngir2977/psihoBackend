package com.example.licenta.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "author")
    private String author;
    @Column(name = "text")
    private String text;
    @Column(name = "date")
    private Date date;
    @Column(name = "chapterId")
    private Integer chapterId;

}
