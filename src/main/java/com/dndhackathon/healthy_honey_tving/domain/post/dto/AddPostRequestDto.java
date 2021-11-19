package com.dndhackathon.healthy_honey_tving.domain.post.dto;

import com.dndhackathon.healthy_honey_tving.global.dto.ChildTagDto;
import com.dndhackathon.healthy_honey_tving.global.entity.ChildTagEntity;
import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import com.dndhackathon.healthy_honey_tving.global.entity.UserEntity;
import com.dndhackathon.healthy_honey_tving.global.enum_type.ParentTag;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.util.Arrays;
import java.util.List;


@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class AddPostRequestDto {
    private String title;
    private String description;
    @URL private String url;
    private Long userUID;
    private ParentTag parentTag;
    private List<String> childTags;

    public @NonNull PostEntity toEntity() {
        return new PostEntity(-1L, title, description, url,
                childTags.stream().map(s -> new ChildTagEntity(s, parentTag)).toList(),
                userUID);
    }
}
