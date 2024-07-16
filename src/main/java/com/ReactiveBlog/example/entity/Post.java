package com.ReactiveBlog.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Post {

    @Id
    private String id;
    private String title;
    private String content;
    private String author;

    public Post(String number, String title, String content, String author) {
    }
}