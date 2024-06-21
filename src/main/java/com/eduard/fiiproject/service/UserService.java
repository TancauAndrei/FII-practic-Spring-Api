package com.eduard.fiiproject.service;

import com.eduard.fiiproject.entity.Post;
import com.eduard.fiiproject.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getByUsername(String username);
    List<User> getAllByKeyword(String keyWord);
    void register(User user);
    void update(User user);
    void delete(String username);
    void deleteAll();
    List<User> getFollowing(String username);
    List<Post> getPosts(String username);
}
