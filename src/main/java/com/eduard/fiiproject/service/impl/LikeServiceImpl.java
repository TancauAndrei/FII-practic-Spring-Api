package com.eduard.fiiproject.service.impl;

import com.eduard.fiiproject.exception.LikeNotFoundException;
import com.eduard.fiiproject.entity.Like;
import com.eduard.fiiproject.repository.LikeRepository;
import com.eduard.fiiproject.service.LikeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public void create(Like like) {
        likeRepository.save(like);
    }

    @Override
    public void delete(Integer likeId) {
        if(likeRepository.existsById(likeId)) {
            likeRepository.deleteById(likeId);
        }else throw new LikeNotFoundException("Like with id" +likeId + " not found");

    }

    @Override
    public Like getLike(String username, Integer postId) {
        return likeRepository.findByUserIdAndPostId(username, postId);
    }

    @Override
    public List<Like> getByPostId(int postId) {
        return likeRepository.findByPostId(postId);
    }
}
