package com.dndhackathon.healthy_honey_tving.domain.post.service;

import com.dndhackathon.healthy_honey_tving.domain.post.dto.AddPostRequestDto;
import com.dndhackathon.healthy_honey_tving.global.data.dto.PostDto;

public interface PostService {
    void add(AddPostRequestDto requestDto);
    long addAndGetId(AddPostRequestDto requestDto);
    PostDto get(Long postUID);
    void remove(Long postUID);
}
