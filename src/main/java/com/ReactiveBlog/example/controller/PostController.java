package com.ReactiveBlog.example.controller;

import com.ReactiveBlog.example.entity.Post;
import com.ReactiveBlog.example.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public Flux<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    @GetMapping("/{id}")
    public Mono<Post> getPostById(@PathVariable String id) {
        return postService.getPostById(id);
    }
    @PostMapping
    public Mono<Post> createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
    @PutMapping("/{id}")
    public Mono<Post> updatePost(@PathVariable String id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deletePost(@PathVariable String id) {
        return postService.deletePost(id);
    }
}

