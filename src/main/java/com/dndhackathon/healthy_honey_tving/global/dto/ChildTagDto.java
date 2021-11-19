package com.dndhackathon.healthy_honey_tving.global.dto;

import com.dndhackathon.healthy_honey_tving.global.enum_type.ParentTag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public record ChildTagDto(String tagName,
                          ParentTag parentTag) {
}
