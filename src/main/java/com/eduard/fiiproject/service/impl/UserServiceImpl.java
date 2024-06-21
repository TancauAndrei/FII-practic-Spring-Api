package com.eduard.fiiproject.service.impl;

import com.eduard.fiiproject.exception.UserAlreadyExists;
import com.eduard.fiiproject.exception.UserNotFoundException;
import com.eduard.fiiproject.entity.Post;
import com.eduard.fiiproject.repository.UserRepository;
import com.eduard.fiiproject.entity.User;
import com.eduard.fiiproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PostServiceImpl postService;
    private final FollowServiceImpl followService;
    private final MentionServiceImpl mentionService;

    public UserServiceImpl(UserRepository userRepository, PostServiceImpl postService, FollowServiceImpl followService, MentionServiceImpl mentionService) {
        this.userRepository = userRepository;
        this.postService = postService;
        this.followService = followService;
        this.mentionService = mentionService;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
    @Override
    public User getByUsername(String username) {
        if(!userRepository.existsByUsername(username)) throw new UserNotFoundException("User " + username + " not found");
        return userRepository.findByUsername(username).get();
    }

    @Override
    public List<User> getAllByKeyword(String keyWord) {
        List<User> u = new ArrayList<>();
        Optional<User> user = userRepository.findByUsername(keyWord);
        user.ifPresent(u::add);
        u.addAll(userRepository.findByFirstName(keyWord));
        u.addAll(userRepository.findByLastName(keyWord));
        user = userRepository.findByEmail(keyWord);
        user.ifPresent(u::add);
        return u;
    }
    @Override
    public void register(User user) {
        if(userRepository.existsByUsername(user.getUsername())) {throw new UserNotFoundException("User " + user.getUsername() + " already exists.");}
        if(userRepository.existsByEmail(user.getEmail())) throw new UserAlreadyExists("User with email " + user.getEmail() + " already exists.");
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
       if(userRepository.existsByUsername(user.getUsername())) throw new UserNotFoundException("User " + user.getUsername() + " not found");
       userRepository.save(user);
    }

    @Override
    public void delete(String username) {
        if(userRepository.existsByUsername(username)) throw new UserNotFoundException("User " + username + " not found");
        userRepository.deleteByUsername(username);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public List<User> getFollowing(String username) {
        return followService.getFollowers(username);
    }

    @Override
    public List<Post> getPosts(String username) {
        return postService.getOwn(username);
    }
}
