package com.dndhackathon.healthy_honey_tving.domain.react.dto;

import com.dndhackathon.healthy_honey_tving.global.data.enum_type.React;

public record ReactRequestDto (
        React react,
        Long postUID,
        Long userUID
){ }
