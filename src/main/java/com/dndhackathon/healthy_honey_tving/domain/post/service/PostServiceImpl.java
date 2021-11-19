package com.dndhackathon.healthy_honey_tving.domain.post.service;

import com.dndhackathon.healthy_honey_tving.domain.post.dto.AddPostRequestDto;
import com.dndhackathon.healthy_honey_tving.domain.post.repository.PostRepository;
import com.dndhackathon.healthy_honey_tving.domain.post.repository.UserRepository;
import com.dndhackathon.healthy_honey_tving.global.dto.PostDto;
import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public long addPost(AddPostRequestDto requestDto) {
        PostEntity postEntity = requestDto.toEntity();
        userRepository.save(postEntity.getAuthor());
        return postRepository.save(postEntity).getPostUID(); //포스트 UID 를 반환한다.
    }

    @Override
    public PostDto getPost(Long postUID) {
        return postRepository.getById(postUID).toDto();
    }

    @Override
    public void removePost(Long postUID) {
        postRepository.deleteById(postUID);
    }
}
