package com.dndhackathon.healthy_honey_tving.domain.post.service;

import com.dndhackathon.healthy_honey_tving.domain.post.dto.AddPostRequestDto;
import org.springframework.stereotype.Service;

public interface PostService {
    void addPost(AddPostRequestDto requestDto);
}
