package com.microservice.comment.service.impl;

import com.microservice.comment.config.RestTemplateConfig;
import com.microservice.comment.entity.Comment;
import com.microservice.comment.payload.CommentDto;
import com.microservice.comment.payload.PostDto;
import com.microservice.comment.repository.CommentRepository;
import com.microservice.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService
{
    private CommentRepository commentRepo;
    private RestTemplateConfig restTemplateConfig;

    public CommentServiceImpl(CommentRepository commentRepo, RestTemplateConfig restTemplateConfig) {
        this.commentRepo = commentRepo;
        this.restTemplateConfig = restTemplateConfig;
    }

    @Override
    public CommentDto saveComment(CommentDto commentDto)
    {
        PostDto postDto = restTemplateConfig.getRestTemplate().getForObject("http://POST-SERVICE/ms/api/posts/" + commentDto.getPostId(), PostDto.class);
        if(postDto!=null)
        {
            Comment comment = new Comment();
            comment.setId(UUID.randomUUID().toString());
            comment.setName(commentDto.getName());
            comment.setEmail(commentDto.getEmail());
            comment.setBody(commentDto.getBody());
            comment.setPostId(commentDto.getPostId());

            Comment savedComment = commentRepo.save(comment);
            return mapToDto(savedComment);
        }
        return null;
    }

    public List<CommentDto> findAllCommentByPostId(String postId)
    {
        List<Comment> commentLst = commentRepo.findByPostId(postId);
        List<CommentDto> commentDtoList = commentLst.stream().map(this::mapToDto).collect(Collectors.toList());
        return commentDtoList;
    }

    CommentDto mapToDto(Comment comment)
    {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        commentDto.setPostId(comment.getPostId());
        return commentDto;
    }
}
