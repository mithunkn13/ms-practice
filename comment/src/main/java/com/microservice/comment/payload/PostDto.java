package com.microservice.comment.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto
{
    private String postId;
    private String title;
    private String description;
    private String content;
}
