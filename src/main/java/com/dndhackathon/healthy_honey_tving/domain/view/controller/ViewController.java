package com.dndhackathon.healthy_honey_tving.domain.view.controller;

import com.dndhackathon.healthy_honey_tving.domain.view.Service.ViewService;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.Response;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.ResponsePostDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/view")
public class ViewController {

    private final ViewService viewService;

    @GetMapping("/get-all-post")
    public PageInfo<ResponsePostDto> pageInfo(RequestAllPostDto dto, HttpServletRequest request){
        List<ResponsePostDto> responses = viewService.PostAll(dto);
        PageHelper.startPage(request);
        return PageInfo.of(responses);
    }

    @GetMapping("/get-post-by-tag")
    public PageInfo<ResponsePostDto> PostByTagApi( RequestPostByTagDto dto, HttpServletRequest request){
        List<ResponsePostDto> responses = viewService.PostTagAll(dto);
        PageHelper.startPage(request);
        return PageInfo.of(responses);
    }
}
