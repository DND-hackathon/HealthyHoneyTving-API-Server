package com.dndhackathon.healthy_honey_tving.global.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChildTagEntity {
    private String tag_name;
    private enum paren_tag{
        health, media
    }
}
