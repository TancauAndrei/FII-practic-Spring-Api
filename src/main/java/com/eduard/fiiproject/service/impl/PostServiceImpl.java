package com.eduard.fiiproject.service.impl;

import com.eduard.fiiproject.exception.PostNotFoundException;
import com.eduard.fiiproject.entity.Post;
import com.eduard.fiiproject.repository.PostRepository;
import com.eduard.fiiproject.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getOwn(String username) {
        return postRepository.findByUsername(username);
    }

    @Override
    public List<Post> getOwnNewerThan(String username, LocalDateTime time) {
        return postRepository.findByUsernameNewerThan(username, time);
    }


    @Override
    public void create(Post post) {
        post.setTimestamp(LocalDateTime.now());
        postRepository.save(post);
    }
    @Override
    public void delete(Integer postId) {
        if(!postRepository.existsById(postId))postRepository.deleteById(postId);
        throw new PostNotFoundException("Post with id " + postId + " not found");
    }

    @Override
    public void update(Post post) {
        if(postRepository.existsById(post.getId())){
            postRepository.save(post);
        }else throw new PostNotFoundException("Post with id " + post.getId() + " already exists. Try posting as new.");
    }

    @Override
    public Post getById(Integer postId) {
        if(postRepository.existsById(postId))return postRepository.findById(postId).get();
        throw new PostNotFoundException("Post with id " + postId + " not found");
    }
}
