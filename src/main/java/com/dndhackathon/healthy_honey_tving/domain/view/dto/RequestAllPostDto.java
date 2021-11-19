package com.dndhackathon.healthy_honey_tving.domain.view.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RequestAllPostDto {
    private String parent_tag;
    private int page;
    private int size;
}
