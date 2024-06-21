package com.eduard.fiiproject;

import com.eduard.fiiproject.entity.*;
import com.eduard.fiiproject.exception.FollowNotValidException;
import com.eduard.fiiproject.service.impl.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class APIService {
    public final UserServiceImpl userService;
    public final PostServiceImpl postService;
    public final LikeServiceImpl likeService;
    public final FollowServiceImpl followService;
    public final MentionServiceImpl mentionService;
    public final ReplyServiceImpl replyService;

    public APIService(MentionServiceImpl mentionService, UserServiceImpl userService, PostServiceImpl postService, LikeServiceImpl likeService, FollowServiceImpl followService, ReplyServiceImpl replyService) {
        this.mentionService = mentionService;
        this.userService = userService;
        this.postService = postService;
        this.likeService = likeService;
        this.followService = followService;
        this.replyService = replyService;
    }


    public void follow(String username, String followerUsername){
        if(username.equals(followerUsername)) {
            throw new FollowNotValidException("user and follower can not be the same");
        }
        if(followService.exists(username, followerUsername)){
            throw new FollowNotValidException("user "+ username + " already follows "+ followerUsername);
        }
        User user = userService.getByUsername(username);
        User follower = userService.getByUsername(followerUsername);
        followService.create(new Follow(user, follower));
    }

    public void post(String username, String message) {
        User user = userService.getByUsername(username);
        postService.create(new Post(user, message));
    }

    public List<Post> getPosts(String username, LocalDate date) {
        if(date == null) return postService.getOwn(username);
        return postService.getOwnNewerThan(username, LocalDateTime.from(date));
    }

    public List<Post> getFeed(String username) {
        List<Post> feed = new ArrayList<>();
        List<User> followers = followService.getFollowers(username);
        for(User user : followers){
            feed.addAll(postService.getOwn(user.getUsername()));
        }
        return feed;
    }

    public void like(String username, Integer postId) {
        likeService.create(new Like(userService.getByUsername(username), postService.getById(postId)));
    }

    public void reply(String username, Integer postId, String message) {
        replyService.create(new Reply(userService.getByUsername(username), postService.getById(postId), message));
    }

    public List<User> getAllByKeyword(String keyWord) {
        return userService.getAllByKeyword(keyWord);
    }

    public void register(User user) {
        userService.register(user);
    }

    public void unregister(String username) {
        userService.delete(username);
    }

    public void unfollow(String userId, String followerId) {
        followService.delete(userId, followerId);
    }

    public void removePost(int postId) {
        for(Like l : likeService.getByPostId(postId)){
            likeService.delete(l.getId());
        }
        for(Reply r : replyService.getByPostId(postId)){
            replyService.delete(r.getId());
        }
        postService.delete(postId);
    }

    public void repost(String username, int postId) {
        Post post = postService.getById(postId);
        User user = userService.getByUsername(username);
        postService.create(new Post(user, "REPOSTED FROM " + post.getUser().getUsername() + ": " + post.getMessage()));
    }

    public List<Post> getMentions(String username) {
        return mentionService.getMentions(userService.getByUsername(username));
    }

    public void dislike(String username, Integer postId) {
        likeService.delete(likeService.getLike(username, postId).getId());
    }
}
