package com.dndhackathon.healthy_honey_tving.global.dto;

import com.dndhackathon.healthy_honey_tving.global.enum_type.ParentTag;

public record ChildTagDto(String tagName,
                          ParentTag parentTag) {
}
