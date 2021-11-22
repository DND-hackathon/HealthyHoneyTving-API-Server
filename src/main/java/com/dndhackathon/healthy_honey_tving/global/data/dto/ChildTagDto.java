package com.dndhackathon.healthy_honey_tving.global.data.dto;

import com.dndhackathon.healthy_honey_tving.global.data.entity.ChildTagEntity;
import com.dndhackathon.healthy_honey_tving.global.data.enum_type.ParentTag;

public record ChildTagDto(String tagName,
                          ParentTag parentTag) implements ConvertableDto<ChildTagEntity> {
    @Override
    public ChildTagEntity toEntity() {
        return new ChildTagEntity(tagName, parentTag);
    }
}
