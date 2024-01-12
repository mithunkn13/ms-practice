package com.microservice.post.controller;

import com.microservice.post.payload.PostDto;
import com.microservice.post.payload.PostResponseDto;
import com.microservice.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ms/api/posts")
@RestController
public class PostController
{
    @Autowired
    private PostService postService;
    @PostMapping
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto)
    {
        PostDto savedPostDto = postService.savePost(postDto);
        return new ResponseEntity<>(savedPostDto, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable String postId)
    {
        PostDto postDto = postService.getPostById(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<PostResponseDto> getPostWithComments(@PathVariable String postId)
    {
        PostResponseDto postResponseDto = postService.getPostWithComments(postId);
        return new ResponseEntity<>(postResponseDto,HttpStatus.OK);
    }
}
