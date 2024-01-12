package com.microservice.comment.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto
{

    private String id;
    private String name;
    private String email;
    private String body;
    private String postId;
}
