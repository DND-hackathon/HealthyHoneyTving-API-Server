package com.dndhackathon.healthy_honey_tving.domain.react.service;

import com.dndhackathon.healthy_honey_tving.domain.react.dto.ReactRequestDto;

public interface ReactService {
    void add(ReactRequestDto requestDto);
    void remove(ReactRequestDto requestDto);
}
