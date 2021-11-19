package com.dndhackathon.healthy_honey_tving.global.dto;

import com.dndhackathon.healthy_honey_tving.global.enum_type.ParentTag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@RequiredArgsConstructor
@Getter
public record PostDto(Long postUID, String title, @URL String link, Long userUID,
                      ParentTag parentTag,
                      List<ChildTagDto> childTags) {
}
