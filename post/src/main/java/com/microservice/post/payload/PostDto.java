package com.microservice.post.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto
{
    private String id;
    private String title;
    private String description;
    private String content;
}
