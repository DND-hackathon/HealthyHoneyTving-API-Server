package com.dndhackathon.healthy_honey_tving.domain.view.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RequestPostByTagDto {
    private String parent_tag;
    private String child_tag;
    private int page;
    private int size;

}
