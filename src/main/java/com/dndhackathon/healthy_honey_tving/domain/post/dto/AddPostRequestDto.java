package com.dndhackathon.healthy_honey_tving.domain.post.dto;

import com.dndhackathon.healthy_honey_tving.global.dto.ChildTagDto;
import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import com.dndhackathon.healthy_honey_tving.global.enum_type.ParentTag;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public record AddPostRequestDto(String title,
                                @URL String url,
                                Long userUID,
                                ParentTag parentTag,
                                List<ChildTagDto> childTags) {
    public PostEntity toEntity() {
        //TODO
        return null;
    }
}
