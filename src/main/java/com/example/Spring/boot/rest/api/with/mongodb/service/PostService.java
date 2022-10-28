package com.example.Spring.boot.rest.api.with.mongodb.service;

import com.example.Spring.boot.rest.api.with.mongodb.document.Post;
import com.example.Spring.boot.rest.api.with.mongodb.repo.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
        @Autowired
        private PostsRepo repository;

        public List<Post> getPosts(){
            return repository.findAll();
        }

        public Object getPostById(String id){
            if (repository.findById(id) != null)
                return repository.findById(id);
            return "{ \t\"message\": \"Not found\"\t}";
        }

        public Post getPostByTitle(String title){
            return repository.findByTitle(title);
        }

        public List<Post> getPostByCategory(String cat){
            return repository.findByCategory(cat);
        }

        public Post createPost(Post post){
            return repository.save(post);
        }

        public Post updatePost(Post post){
            Post p = repository.findById(post.getId()).orElse(null);
            p.setTitle(post.getTitle());
            p.setBody(post.getBody());
            p.setCategory(post.getCategory());

            return  p;
        }

        public Map<String, String> deletePost(String id){
            repository.deleteById(id);
            Map<String, String> map = new HashMap<>();
            map.put("message", "Post with id "+id+" deleted successfully");
            return map;
        }
}
