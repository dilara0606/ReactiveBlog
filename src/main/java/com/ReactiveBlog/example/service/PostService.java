package com.ReactiveBlog.example.service;

import com.ReactiveBlog.example.entity.Post;
import com.ReactiveBlog.example.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Flux<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public Mono<Post> getPostById(String id) {
        return postRepository.findById(id);
    }
    public Mono<Post> createPost(Post post) {
        return postRepository.save(post);
    }
    public Mono<Post> updatePost(String id, Post post) {
        return postRepository.findById(id)
                .flatMap(existingPost -> {
                    existingPost.setTitle(post.getTitle());
                    existingPost.setContent(post.getContent());
                    existingPost.setAuthor(post.getAuthor());
                    return postRepository.save(existingPost);
                });
    }
    public Mono<Void> deletePost(String id) {
        return postRepository.deleteById(id);
    }
}

