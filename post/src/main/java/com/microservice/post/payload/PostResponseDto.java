package com.microservice.post.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto
{
    private String id;
    private String title;
    private String description;
    private String content;

    private List<CommentDto> commentDtoList;
}
