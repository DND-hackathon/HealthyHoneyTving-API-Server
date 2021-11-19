package com.dndhackathon.healthy_honey_tving.domain.view.Service;

import com.dndhackathon.healthy_honey_tving.domain.post.repository.PostRepository;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.ResponsePostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViewService {
    private final PostRepository postRepository;

    public ResponsePostDto PostAll(RequestAllPostDto dto){
        ResponsePostDto responsePostDto = ResponsePostDto.builder()
                .parent_tag(dto.getParent_tag())
                .page(dto.getPage())
                .size(dto.getSize())
                .postEntityList(postRepository.findAll()).build();
        return responsePostDto;
    }

    public ResponsePostDto PostTagAll(RequestPostByTagDto dto){
        ResponsePostDto responsePostDto = ResponsePostDto.builder().child_tag(dto.getChild_tag())
                .parent_tag(dto.getParent_tag())
                .page(dto.getPage())
                .size(dto.getSize())
                .postEntityList(postRepository.findAllByChildTagEntitiesContains(dto.getChild_tag())).build();
        return responsePostDto;
    }
}
