package com.dndhackathon.healthy_honey_tving.domain.post.service;

import com.dndhackathon.healthy_honey_tving.domain.post.dto.AddPostRequestDto;
import com.dndhackathon.healthy_honey_tving.global.dto.PostDto;
import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import com.dndhackathon.healthy_honey_tving.global.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ChildTagRepository childTagRepository;

    @Override
    public long addPost(AddPostRequestDto requestDto) {
        PostEntity postEntity = requestDto.toEntity();
        userRepository.save(postEntity.getAuthor());
        childTagRepository.saveAll(postEntity.getChildTagEntities());
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
