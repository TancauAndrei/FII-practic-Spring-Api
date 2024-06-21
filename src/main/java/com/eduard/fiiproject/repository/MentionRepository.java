package com.eduard.fiiproject.repository;

import com.eduard.fiiproject.entity.Mention;
import com.eduard.fiiproject.entity.Post;
import com.eduard.fiiproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MentionRepository extends JpaRepository<Mention, Integer> {
    @Query("select m.post from Mention m where m.mentionedUser = ?1")
    List<Post> findAllByMentionedUser(User mentionedUser);
}
