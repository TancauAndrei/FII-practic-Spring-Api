package com.eduard.fiiproject.service.impl;

import com.eduard.fiiproject.entity.User;
import com.eduard.fiiproject.exception.FollowNotFoundException;
import com.eduard.fiiproject.entity.Follow;
import com.eduard.fiiproject.repository.FollowRepository;
import com.eduard.fiiproject.service.FollowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    public FollowServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    public void create(Follow follow) {
        follow.setTimestamp(LocalDateTime.now());
        followRepository.save(follow);
    }

    @Transactional
    @Override
    public void delete(String username, String followerUsername) {
        if(followRepository.existsByUserAndFollower(username, followerUsername)) {
            followRepository.deleteByUserAndFollower(username, followerUsername);
        }else throw new FollowNotFoundException(username +" does not follow " + followerUsername);
    }

    @Override
    public boolean exists(String username, String followerUsername) {
        return followRepository.existsByUserAndFollower(username, followerUsername);
    }

    @Override
    public List<User> getFollowers(String username) {
        return followRepository.findAllByUser(username);
    }

}
