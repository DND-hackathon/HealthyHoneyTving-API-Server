package com.dndhackathon.healthy_honey_tving.domain.view.Service;

import com.dndhackathon.healthy_honey_tving.domain.view.repository.ViewRepository;
import com.dndhackathon.healthy_honey_tving.domain.post.repository.PostRepository;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestGetAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestGetPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.ResponsePostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ViewService {
    private final PostRepository postRepository;
    private final ViewRepository viewRepository;

    public List<ResponsePostDto> PostAll(RequestGetAllPostDto dto){
        List<ResponsePostDto> list =  viewRepository.selectGetAllPost(dto);
        childTag(list);
        return list;
    }
    public List<ResponsePostDto> PostTagAll(RequestGetPostByTagDto dto){
        List<ResponsePostDto> list = viewRepository.selectGetByTag(dto);
        childTag(list);
        return list;
    }
    private void childTag (List<ResponsePostDto> list){
        list.forEach(responsePostDto -> responsePostDto.setChildTags(
                viewRepository.selectTag(responsePostDto.getPostUID())));
    }
}
