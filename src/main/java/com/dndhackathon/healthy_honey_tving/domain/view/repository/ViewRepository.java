package com.dndhackathon.healthy_honey_tving.domain.view.repository;

import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.mapper.ViewMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ViewRepository implements ViewMapper {

    ViewMapper mapper;
    SqlSession sqlSession;

    public ViewRepository(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        mapper = sqlSession.getMapper(ViewMapper.class);
    }
    @Override
    public List<HashMap<String, Object>> selectGetAllPost(RequestAllPostDto dto) {
        return mapper.selectGetAllPost(dto);
    }

    @Override
    public List<HashMap<String, Object>> selectGetByTag(RequestPostByTagDto dto) {
        return mapper.selectGetByTag(dto);
    }

    @Override
    public List<String> selectTag(Integer post_uid) {
        return mapper.selectTag(post_uid);
    }
}
