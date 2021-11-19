package com.dndhackathon.healthy_honey_tving.domain.view.controller;

import com.dndhackathon.healthy_honey_tving.domain.view.Service.ViewService;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestAllPostDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.RequestPostByTagDto;
import com.dndhackathon.healthy_honey_tving.domain.view.dto.ResponsePostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/view")
public class ViewController {

    private final ViewService viewService;

    @GetMapping("/get-all-post")
    public ResponsePostDto api(RequestAllPostDto dto){
        return viewService.PostAll(dto);
    }


    @GetMapping("/get-post-by-tag")
    public ResponsePostDto api( RequestPostByTagDto dto){
        return viewService.PostTagAll(dto);
    }
}
