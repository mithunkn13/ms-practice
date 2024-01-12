package com.microservice.post.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post
{
    @Id
    private String id;
    @Column(name = "title",length = 100,nullable = false)
    private String title;
    @Column(length = 300, nullable = false)
    private String description;
    @Column(length = 1200,nullable = false)
    private String content;
}
