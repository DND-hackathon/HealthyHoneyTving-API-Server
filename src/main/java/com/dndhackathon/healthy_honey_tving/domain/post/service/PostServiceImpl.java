package com.dndhackathon.healthy_honey_tving.domain.post.service;

import com.dndhackathon.healthy_honey_tving.domain.post.dto.AddPostRequestDto;
import com.dndhackathon.healthy_honey_tving.domain.post.repository.PostRepository;
import com.dndhackathon.healthy_honey_tving.global.dto.PostDto;
import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    @Override
    public long addPost(AddPostRequestDto requestDto) {
        System.out.println(requestDto);
        System.out.println(requestDto.getTitle());
        System.out.println(Arrays.toString(requestDto.getChildTags().toArray()));
        PostEntity postEntity = requestDto.toEntity();
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
