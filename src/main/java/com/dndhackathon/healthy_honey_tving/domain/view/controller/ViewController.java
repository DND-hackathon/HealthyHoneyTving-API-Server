package com.dndhackathon.healthy_honey_tving.domain.view.controller;

import com.dndhackathon.healthy_honey_tving.domain.view.Service.ViewService;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestGetAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestGetPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.ResponsePostDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/view")
public class ViewController {

    private final ViewService viewService;

    @GetMapping("/get-all-post")
    public PageInfo<ResponsePostDto> pageInfo(RequestGetAllPostDto dto, HttpServletRequest request){
        List<ResponsePostDto> responses = viewService.PostAll(dto);
        PageHelper.startPage(request);
        return PageInfo.of(responses);
    }

    @GetMapping("/get-post-by-tag")
    public PageInfo<ResponsePostDto> PostByTagApi(RequestGetPostByTagDto dto, HttpServletRequest request){
        List<ResponsePostDto> responses = viewService.PostTagAll(dto);
        PageHelper.startPage(request);
        return PageInfo.of(responses);
    }
}
