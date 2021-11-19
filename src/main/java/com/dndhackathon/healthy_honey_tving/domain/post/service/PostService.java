package com.dndhackathon.healthy_honey_tving.domain.post.service;

import com.dndhackathon.healthy_honey_tving.domain.post.dto.AddPostRequestDto;
import com.dndhackathon.healthy_honey_tving.global.dto.PostDto;

public interface PostService {
    long addPost(AddPostRequestDto requestDto);

    PostDto getPost(Long postUID);

    void removePost(Long postUID);
}
