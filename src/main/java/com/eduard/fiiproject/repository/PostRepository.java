package com.eduard.fiiproject.repository;

import com.eduard.fiiproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("select p from Post p where p.post_id = ?1 and p.timestamp >= ?2")
    List<Post> findByUsernameNewerThan(String username, LocalDateTime time);
    @Query("select p from Post p where p.user.username = ?1")
    List<Post> findByUsername(String username);
}
