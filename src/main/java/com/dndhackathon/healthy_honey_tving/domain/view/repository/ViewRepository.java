package com.dndhackathon.healthy_honey_tving.domain.view.repository;

import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestGetAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestGetPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.ResponsePostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.mapper.ViewMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ViewRepository implements ViewMapper {
    private final ViewMapper mapper;

    public ViewRepository(SqlSession sqlSession){
        mapper = sqlSession.getMapper(ViewMapper.class);
    }
    @Override
    public List<ResponsePostDto> selectGetAllPost(RequestGetAllPostDto dto) {
        return mapper.selectGetAllPost(dto);
    }

    @Override
    public List<ResponsePostDto> selectGetByTag(RequestGetPostByTagDto dto) {
        return mapper.selectGetByTag(dto);
    }

    @Override
    public List<String> selectTag(Integer post_uid) {
        return mapper.selectTag(post_uid);
    }
}
