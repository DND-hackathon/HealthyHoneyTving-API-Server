package com.dndhackathon.healthy_honey_tving.domain.view.dto;

import com.dndhackathon.healthy_honey_tving.global.enum_type.ParentTag;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RequestPostByTagDto {
    private ParentTag parent_tag;
    private String child_tag;
    private int page;
    private int size;

}
