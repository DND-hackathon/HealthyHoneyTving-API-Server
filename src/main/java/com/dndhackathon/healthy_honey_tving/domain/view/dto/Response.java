package com.dndhackathon.healthy_honey_tving.domain.view.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Response {
    private int page;
    private int size;
    List<ResponsePostDto> responsePostDto;
}
