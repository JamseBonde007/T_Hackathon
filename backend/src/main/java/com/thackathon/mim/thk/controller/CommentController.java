package com.thackathon.mim.thk.controller;

import com.thackathon.mim.thk.entity.Comment;
import com.thackathon.mim.thk.service.CommentService;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(@NonNull final CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id){
        return ResponseEntity.ok(commentService.getComment(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Comment>> getComments(Pageable page,
                                                     @RequestParam Long post_id){
        return ResponseEntity.ok(commentService.getComments(page, post_id));
    }
}
