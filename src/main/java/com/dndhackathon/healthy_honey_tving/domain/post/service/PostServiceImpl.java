package com.dndhackathon.healthy_honey_tving.domain.post.service;

import com.dndhackathon.healthy_honey_tving.domain.post.dto.AddPostRequestDto;
import com.dndhackathon.healthy_honey_tving.domain.post.repository.ChildTagRepository;
import com.dndhackathon.healthy_honey_tving.domain.post.repository.UserRepository;
import com.dndhackathon.healthy_honey_tving.global.data.dto.PostDto;
import com.dndhackathon.healthy_honey_tving.global.data.entity.PostEntity;
import com.dndhackathon.healthy_honey_tving.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ChildTagRepository childTagRepository;

    @Override
    public void add(AddPostRequestDto requestDto) {
        PostEntity postEntity = requestDto.toEntity();
        userRepository.save(postEntity.getAuthor());
        childTagRepository.saveAll(postEntity.getChildTagEntities());
        postRepository.save(postEntity); //포스트 UID 를 반환한다.
    }

    @Override
    public long addAndGetId(AddPostRequestDto requestDto) {
        PostEntity postEntity = requestDto.toEntity();
        userRepository.save(postEntity.getAuthor());
        childTagRepository.saveAll(postEntity.getChildTagEntities());
        return postRepository.save(postEntity).getPostUID(); //포스트 UID 를 반환한다.
    }

    @Override
    public PostDto get(Long postUID) {
        return postRepository.getById(postUID).toDto();
    }

    @Override
    public void remove(Long postUID) {
        postRepository.deleteById(postUID);
    }
}
