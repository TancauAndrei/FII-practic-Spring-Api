package com.eduard.fiiproject;


import com.eduard.fiiproject.entity.Post;
import com.eduard.fiiproject.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    private final APIService APIService;
    public APIController(APIService APIService) {
        this.APIService = APIService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid User user) {
        APIService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }
    @DeleteMapping("/unregister")
    public ResponseEntity<String> unregister(@RequestParam String username) {
        APIService.unregister(username);
        return ResponseEntity.ok("User unregistered successfully");
    }

    @GetMapping("/search/{keyWord}")
    public ResponseEntity<List<User>> search(@PathVariable String keyWord) {
        return ResponseEntity.ok(APIService.getAllByKeyword(keyWord));
    }

    @PostMapping("/follow")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> follow(@RequestParam String username, @RequestParam String followerUsername) {
        APIService.follow(username, followerUsername);
        return ResponseEntity.ok("User " + username + " followed " + followerUsername + " successfully");
    }
    @DeleteMapping("/unfollow")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> unfollow(@RequestParam String username, @RequestParam String followerUsername) {
        APIService.unfollow(username, followerUsername);
        return ResponseEntity.ok("User " + username + " unfollowed " + followerUsername + " successfully");
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> post(@RequestParam String username, @RequestBody @Valid @NotEmpty String message) {
        APIService.post(username, message);
        return ResponseEntity.ok("User " + username + " posted message successfully");
    }
    @PostMapping("/repost")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> repost(@RequestParam String username, @RequestParam int postId) {
        APIService.repost(username, postId);
        return ResponseEntity.ok("User " + username + " reposted message successfully");
    }
    @DeleteMapping("/post/delete")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> removePost(@RequestParam int postId) {
        APIService.removePost(postId);
        return ResponseEntity.ok("Post with id " + postId + " delete successfully");
    }
    @GetMapping("/user/{username}/posts")
    public ResponseEntity<List<Post>> getPosts(@PathVariable String username, @RequestParam LocalDate date) {
        return ResponseEntity.ok(APIService.getPosts(username, date));
    }
    @GetMapping("/user/{username}/mentions")
    public ResponseEntity<List<Post>> getMentions(@PathVariable String username) {
        return ResponseEntity.ok(APIService.getMentions(username));
    }

    @GetMapping("/user/{username}/feed")
    public ResponseEntity<List<Post>> getFeed(@PathVariable String username) {
        return ResponseEntity.ok(APIService.getFeed(username));
    }
    @PostMapping("/like")
    public ResponseEntity<String> like(@RequestParam String username, @RequestParam Integer postId) {
        APIService.like(username, postId);
        return ResponseEntity.ok("Like successfully");
    }
    @DeleteMapping("/dislike")
    public ResponseEntity<String> dislikeike(@RequestParam String username, @RequestParam Integer postId) {
        APIService.dislike(username, postId);
        return ResponseEntity.ok("Like successfully");
    }
    @PostMapping("/reply")
    public ResponseEntity<String> reply(@RequestParam String username, @RequestParam Integer postId,@RequestBody String message) {
        APIService.reply(username, postId, message);
        return ResponseEntity.ok("Reply successfully");
    }
}
