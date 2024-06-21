package com.eduard.fiiproject.repository;

import com.eduard.fiiproject.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    @Query("select r from Reply r where r.parent.post_id = ?1")
    List<Reply> findByPostId(Integer post_id);
}
