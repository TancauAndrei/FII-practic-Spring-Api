package com.eduard.fiiproject.repository;

import com.eduard.fiiproject.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    @Query("select l from Like l where l.post.post_id = ?2 and l.user.username = ?1")
    Like findByUserIdAndPostId(String username, Integer postId);
    @Query("select l from Like l where l.post.post_id = ?1")
    List<Like> findByPostId(Integer postId);
}
