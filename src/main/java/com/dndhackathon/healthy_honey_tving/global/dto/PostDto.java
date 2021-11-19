package com.dndhackathon.healthy_honey_tving.global.dto;

import com.dndhackathon.healthy_honey_tving.global.enum_type.ParentTag;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public record PostDto(Long postUID, String title, @URL String link, String description, Long userUID,
                      ParentTag parentTag,
                      List<ChildTagDto> childTags) {
}
