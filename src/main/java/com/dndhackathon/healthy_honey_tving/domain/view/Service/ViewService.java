package com.dndhackathon.healthy_honey_tving.domain.view.Service;

import com.dndhackathon.healthy_honey_tving.domain.post.repository.PostRepository;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.ResponsePostDto;
import com.dndhackathon.healthy_honey_tving.global.entity.ChildTagEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViewService {
    private final PostRepository postRepository;

    public ResponsePostDto PostAll(RequestAllPostDto dto){
        return ResponsePostDto.builder()
                .parent_tag(dto.getParent_tag())
                .page(dto.getPage())
                .size(dto.getSize())
                .postEntityList(postRepository.findAll()).build();
    }

    public ResponsePostDto PostTagAll(RequestPostByTagDto dto){
        return ResponsePostDto.builder().child_tag(dto.getChild_tag())
                .parent_tag(dto.getParent_tag())
                .page(dto.getPage())
                .size(dto.getSize())
                .postEntityList(postRepository.findAllByChildTagEntitiesContains(new ChildTagEntity(dto.getChild_tag(), dto.getParent_tag()))).build();
    }
}
