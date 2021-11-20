package com.dndhackathon.healthy_honey_tving.domain.view.mapper;

import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.ResponsePostDto;

import java.util.HashMap;
import java.util.List;

public interface ViewMapper {

    public List<ResponsePostDto> selectGetAllPost(RequestAllPostDto dto);
    public List<ResponsePostDto> selectGetByTag(RequestPostByTagDto dto);
    public List<String> selectTag(Integer post_uid);
}
