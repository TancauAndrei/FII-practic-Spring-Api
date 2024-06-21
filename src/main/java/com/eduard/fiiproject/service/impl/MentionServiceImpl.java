package com.eduard.fiiproject.service.impl;

import com.eduard.fiiproject.exception.MentionNotFoundException;
import com.eduard.fiiproject.entity.Post;
import com.eduard.fiiproject.entity.User;
import com.eduard.fiiproject.repository.MentionRepository;
import com.eduard.fiiproject.entity.Mention;
import com.eduard.fiiproject.service.MentionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentionServiceImpl implements MentionService {

    private final MentionRepository mentionRepository;

    public MentionServiceImpl(MentionRepository mentionRepository) {
        this.mentionRepository = mentionRepository;
    }

    @Override
    public void create(Mention mention) {
        mentionRepository.save(mention);
    }

    @Override
    public List<Post> getMentions(User user) {
        return mentionRepository.findAllByMentionedUser(user);
    }
}
