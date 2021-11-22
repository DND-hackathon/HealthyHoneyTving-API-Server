package com.dndhackathon.healthy_honey_tving.domain.post.dto;

import com.dndhackathon.healthy_honey_tving.global.data.entity.ChildTagEntity;
import com.dndhackathon.healthy_honey_tving.global.data.entity.PostEntity;
import com.dndhackathon.healthy_honey_tving.global.data.entity.UserEntity;
import com.dndhackathon.healthy_honey_tving.global.data.enum_type.ParentTag;
import org.hibernate.validator.constraints.URL;

import java.sql.Date;
import java.util.List;

public record AddPostRequestDto (
        String title,
        String description,
        @URL String url,
        Long userUID,
        ParentTag parentTag,
        List<String> childTags,
        long createdAt,
        String previewImageUrl
        ) {
    public PostEntity toEntity() {
        List<ChildTagEntity> childTagEntities =
                childTags.stream().map(s -> new ChildTagEntity(s, parentTag)).toList();
        UserEntity author = new UserEntity(userUID);
        Date createdDate = new Date(createdAt);

        return new PostEntity(
                PostEntity.DEFAULT_ID, title, url, description,
                childTagEntities, author, createdDate, previewImageUrl
        );
    }
}
