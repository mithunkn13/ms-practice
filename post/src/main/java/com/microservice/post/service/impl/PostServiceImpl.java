package com.microservice.post.service.impl;

import com.microservice.post.config.RestTemplateConfig;
import com.microservice.post.entity.Post;
import com.microservice.post.payload.PostDto;
import com.microservice.post.payload.PostResponseDto;
import com.microservice.post.repository.PostRepository;
import com.microservice.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService
{
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private RestTemplateConfig restTemplateConfig;
    @Override
    public PostDto savePost(PostDto postDto)
    {
        String postId = UUID.randomUUID().toString();

        Post post = new Post();
        post.setId(postId);
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post savedPost = postRepository.save(post);
        PostDto savedPostDto = mapToPostDto(savedPost);
        return savedPostDto;
    }

    @Override
    public PostDto getPostById(String postId) {
        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();
        return mapToPostDto(post);
    }

    @Override
    public PostResponseDto getPostWithComments(String postId)
    {
        Post post = postRepository.findById(postId).get();
        ArrayList commentsDtoList = restTemplateConfig.getRestTemplate().getForObject("http://COMMENT-SERVICE/ms/api/comments/"+postId, ArrayList.class);

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(post.getId());
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setContent(post.getContent());
        postResponseDto.setDescription(post.getDescription());
        postResponseDto.setCommentDtoList(commentsDtoList);

        return postResponseDto;
    }

    private PostDto mapToPostDto(Post post)
    {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

}
