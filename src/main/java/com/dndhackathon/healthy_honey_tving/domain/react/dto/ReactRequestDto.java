package com.dndhackathon.healthy_honey_tving.domain.react.dto;

import com.dndhackathon.healthy_honey_tving.global.enum_type.React;
import lombok.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class ReactRequestDto {
    private React react;
    private Long postUID;
    private Long userUID;
}
