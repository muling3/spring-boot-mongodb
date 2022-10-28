package com.example.Spring.boot.rest.api.with.mongodb.repo;

import com.example.Spring.boot.rest.api.with.mongodb.document.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostsRepo extends MongoRepository<Post, String> {
    Post findByTitle(String title);

    List<Post> findByCategory(String cat);
}
