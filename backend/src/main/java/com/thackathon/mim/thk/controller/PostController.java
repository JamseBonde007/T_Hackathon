package com.thackathon.mim.thk.controller;

import com.thackathon.mim.thk.entity.Post;
import com.thackathon.mim.thk.service.PostService;
import lombok.NonNull;
import org.springframework.data.domain.Page;
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
@RequestMapping(value = "/post")
public class PostController {

    private final PostService postService;

    public PostController(@NonNull final PostService postService){
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPost(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Post>> getPosts(Pageable page,
                                               @RequestParam(required = false) boolean visibility){
        return ResponseEntity.ok(postService.getPosts(page, visibility));
    }
}
