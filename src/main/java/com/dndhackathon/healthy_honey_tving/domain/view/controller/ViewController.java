package com.dndhackathon.healthy_honey_tving.domain.view.controller;

import com.dndhackathon.healthy_honey_tving.domain.view.Service.ViewService;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.ResponsePostDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/view")
public class ViewController {

    private final ViewService viewService;

    @GetMapping("/get-all-post")
    public List<HashMap<String, Object>> pageInfo(RequestAllPostDto dto, HttpServletRequest request){
        List<HashMap<String, Object>> map = viewService.PostAll(dto);
        PageHelper.startPage(request);
        return map;
    }


    @GetMapping("/get-post-by-tag")
    public List<HashMap<String, Object>> PostByTagApi( RequestPostByTagDto dto, Pageable pageable){
        List<HashMap<String, Object>> map = viewService.PostTagAll(dto);
        return map;
    }
}
