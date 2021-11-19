package com.dndhackathon.healthy_honey_tving.global.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostTagEntity {

    private Long relation_uid;
    private Long post_uid;
    private Long child_tag_uid;
}
