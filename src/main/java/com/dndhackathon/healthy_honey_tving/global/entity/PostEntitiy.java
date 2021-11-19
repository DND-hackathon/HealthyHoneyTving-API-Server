package com.dndhackathon.healthy_honey_tving.global.entity;

import lombok.*;
import org.springframework.context.annotation.Primary;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEntitiy {
    private Long post_uid;
    private String title;
    private String link;
    private String childTag;


}
