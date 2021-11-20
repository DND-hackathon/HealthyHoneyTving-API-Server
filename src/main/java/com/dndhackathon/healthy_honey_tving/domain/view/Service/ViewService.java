package com.dndhackathon.healthy_honey_tving.domain.view.Service;

import com.dndhackathon.healthy_honey_tving.domain.view.dto.Response;
import com.dndhackathon.healthy_honey_tving.domain.view.repository.ViewRepository;
import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import com.dndhackathon.healthy_honey_tving.global.repository.PostRepository;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.ResponsePostDto;
import com.dndhackathon.healthy_honey_tving.global.entity.ChildTagEntity;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ViewService {
    private final PostRepository postRepository;
    private final ViewRepository viewRepository;

    public List<ResponsePostDto> PostAll(RequestAllPostDto dto){
        List<ResponsePostDto> list =  viewRepository.selectGetAllPost(dto);
        list = childTag(list);
        return list;
//        PageRequest pageRequest = PageRequest.of(dto.getPage(), dto.getSize());
//        List<PostEntity> page = postRepository.findAllByChildTagEntitiesLike(new ChildTagEntity("", dto.getParent_tag()));
//        return ResponsePostDto.builder()
//                .parent_tag(dto.getParent_tag())
//                .page(dto.getPage())
//                .size(dto.getSize())
//                .postEntityList(page).build();
    }
    public List<ResponsePostDto> PostTagAll(RequestPostByTagDto dto){
        List<ResponsePostDto> list = viewRepository.selectGetByTag(dto);
        list = childTag(list);
        return list;
//        for(int i = 0 ; i < list.size(); i++){
//            List<String> tag = viewRepository.selectTag(Integer.parseInt((String)list.get(i).get("post_uid").toString()));
//        }
//        PageRequest pageRequest = PageRequest.of(dto.getPage(), dto.getSize());
//        return ResponsePostDto.builder().child_tag(dto.getChild_tag())
//                .parent_tag(dto.getParent_tag())
//                .page(dto.getPage())
//                .size(dto.getSize())
//                .postEntityList(postRepository.findAllByChildTagEntitiesContains(new ChildTagEntity(dto.getChild_tag(), dto.getParent_tag()))).build();

    }
    private List<ResponsePostDto> childTag (List<ResponsePostDto> list){
        for(int i = 0 ; i < list.size(); i++){
            Integer data = list.get(i).getPost_uid();
            List<String> tag = viewRepository.selectTag(data);
            list.get(i).setChild_tags(tag);
        }
        return list;
    }
}
