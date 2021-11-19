package com.dndhackathon.healthy_honey_tving.global.dto;

import com.dndhackathon.healthy_honey_tving.global.entity.ChildTagEntity;
import com.dndhackathon.healthy_honey_tving.global.enum_type.ParentTag;

public record ChildTagDto(String tagName,
                          ParentTag parentTag) {
    public ChildTagEntity toEntity() {
        return new ChildTagEntity(tagName, parentTag);
    }
}
