package com.microservice.comment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "comment")
public class Comment
{
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false ,length = 50)
    private String email;
    @Column(nullable = false,length = 800)
    private String body;
    @Column(nullable = false,length = 50)
    private String postId;
}


