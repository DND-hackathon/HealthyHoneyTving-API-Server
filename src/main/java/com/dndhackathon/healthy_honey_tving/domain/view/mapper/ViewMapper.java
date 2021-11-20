package com.dndhackathon.healthy_honey_tving.domain.view.mapper;

import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestPostByTagDto;

import java.util.HashMap;
import java.util.List;

public interface ViewMapper {

    public List<HashMap<String, Object>> selectGetAllPost(RequestAllPostDto dto);
    public List<HashMap<String, Object>> selectGetByTag(RequestPostByTagDto dto);
    public List<String> selectTag(Integer post_uid);
}
