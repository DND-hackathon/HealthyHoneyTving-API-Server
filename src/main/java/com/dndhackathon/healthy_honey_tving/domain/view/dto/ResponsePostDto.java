package com.dndhackathon.healthy_honey_tving.domain.view.dto;

import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import com.dndhackathon.healthy_honey_tving.global.enum_type.ParentTag;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResponsePostDto {
    private ParentTag parent_tag;
    private String child_tag;
    private int page;
    private int size;
    private List<PostEntity> postEntityList;
}
