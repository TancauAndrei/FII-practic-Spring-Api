package com.eduard.fiiproject.service;

import com.eduard.fiiproject.entity.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> getAll();
    List<Reply> getByPostId(Integer postId);
    void delete(Integer replyId);
    void create(Reply reply);
    void update(Reply reply);
}
