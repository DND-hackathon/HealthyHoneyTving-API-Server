package com.dndhackathon.healthy_honey_tving.domain.react.controller;

import com.dndhackathon.healthy_honey_tving.domain.react.dto.ReactRequestDto;
import com.dndhackathon.healthy_honey_tving.domain.react.service.ReactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/react")
@RequiredArgsConstructor
public class ReactController {
    private final ReactService reactService;

    @PutMapping("/react")
    public void react(@RequestBody ReactRequestDto requestDto) {
        reactService.addReact(requestDto);
    }

    @DeleteMapping("/react")
    public void unReact(@RequestBody ReactRequestDto requestDto) {
        reactService.removeReact(requestDto);
    }
}
