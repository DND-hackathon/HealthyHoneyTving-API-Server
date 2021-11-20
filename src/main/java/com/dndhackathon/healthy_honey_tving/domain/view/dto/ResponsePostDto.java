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
    private int post_uid;
    private int user_uid;
    private String title;
    private String src;
    private List<String> child_tags;
    private int bad;
    private int good;

}
