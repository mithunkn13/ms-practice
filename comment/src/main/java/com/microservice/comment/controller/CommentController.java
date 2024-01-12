package com.microservice.comment.controller;

import com.microservice.comment.payload.CommentDto;
import com.microservice.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms/api/comments")
public class CommentController
{
    @Autowired
    private CommentService commentService;
    @PostMapping()
    public ResponseEntity<?> saveComment(@RequestBody CommentDto commentDto)
    {
        CommentDto savedCommentDto = commentService.saveComment(commentDto);
        if(savedCommentDto!=null)
        {
            return new ResponseEntity<>(savedCommentDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("No Post Present with id : "+commentDto.getPostId(),HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentDto>> getAllCommentByPostId(@PathVariable String postId)
    {
        List<CommentDto> allCommentByPostId = commentService.findAllCommentByPostId(postId);
        return new ResponseEntity<>(allCommentByPostId,HttpStatus.OK);
    }
}
