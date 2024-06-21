package com.eduard.fiiproject.service.impl;

import com.eduard.fiiproject.exception.ReplyNotFoundException;
import com.eduard.fiiproject.repository.ReplyRepository;
import com.eduard.fiiproject.entity.Reply;
import com.eduard.fiiproject.service.ReplyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    public ReplyServiceImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Override
    public List<Reply> getAll() {
        return replyRepository.findAll();
    }

    @Override
    public List<Reply> getByPostId(Integer postId) {
        return replyRepository.findByPostId(postId);
    }

    @Override
    public void delete(Integer replyId) {
        if(replyRepository.existsById(replyId)){
            replyRepository.deleteById(replyId);
            return;
        }
        throw new ReplyNotFoundException("Reply with id " + replyId + " not found");
    }

    @Override
    public void create(Reply reply) {
        replyRepository.save(reply);
    }

    @Override
    public void update(Reply reply) {
        if(replyRepository.existsById(reply.getId())) replyRepository.save(reply);
        else throw new ReplyNotFoundException("Reply with id " + reply.getId() + " not found");
    }
}
