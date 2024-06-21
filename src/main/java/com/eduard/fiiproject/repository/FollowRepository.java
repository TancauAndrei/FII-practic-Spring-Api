package com.eduard.fiiproject.repository;

import com.eduard.fiiproject.entity.Follow;
import com.eduard.fiiproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
    @Query("select exists (select f from Follow f where f.user.username = ?1 and f.follower.username = ?2)")
    boolean existsByUserAndFollower(String username, String followerUsername);

    @Query("select f from Follow f where f.user.username = ?1 and f.follower.username = ?2")
    Follow findByUserAndFollower(String username, String followerUsername);
    @Modifying
    @Query("delete from Follow f where f.user.username = ?1 and f.follower.username = ?2")
    void deleteByUserAndFollower(String username, String followerUsername);
    @Query("select f.follower from Follow f where f.user.username = ?1 ")
    List<User> findAllByUser(String username);
}
