package com.dndhackathon.healthy_honey_tving.global.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReactEntity {
    private Long relation_uid;
    private Long user_uid;
    private Long post_uid;
    private enum type{
        good, bad
    }
}
