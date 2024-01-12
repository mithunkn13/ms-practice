package com.microservice.post.service;

import com.microservice.post.payload.PostDto;
import com.microservice.post.payload.PostResponseDto;

import java.util.UUID;

public interface PostService
{
    PostDto savePost(PostDto postDto);

    PostDto getPostById(String postId);

    PostResponseDto getPostWithComments(String postId);
}
