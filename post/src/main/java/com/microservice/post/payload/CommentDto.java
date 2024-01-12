package com.microservice.post.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto
{
    private String id;
    private String name;
    private String email;
    private String body;
    private String postId;
}
