package com.dndhackathon.healthy_honey_tving.domain.view.mapper;

import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestGetAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestGetPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.ResponsePostDto;

import java.util.List;

public interface ViewMapper {
    List<ResponsePostDto> selectGetAllPost(RequestGetAllPostDto dto);
    List<ResponsePostDto> selectGetByTag(RequestGetPostByTagDto dto);
    List<String> selectTag(Integer post_uid);
}
