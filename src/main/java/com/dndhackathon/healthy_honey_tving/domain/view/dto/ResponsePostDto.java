package com.dndhackathon.healthy_honey_tving.domain.view.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResponsePostDto {
    private int postUID;
    private int userUID;
    private String title;
    private String src;
    private List<String> childTags;
    private int bad;
    private int good;
}
