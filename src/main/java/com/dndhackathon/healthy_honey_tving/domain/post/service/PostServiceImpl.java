package com.dndhackathon.healthy_honey_tving.domain.post.service;

import com.dndhackathon.healthy_honey_tving.domain.post.dto.AddPostRequestDto;
import com.dndhackathon.healthy_honey_tving.domain.post.repository.PostRepository;
import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    PostRepository postRepository;

    @Override
    public void addPost(AddPostRequestDto requestDto) {
        PostEntity postEntity = requestDto.toEntity();
    }
}
