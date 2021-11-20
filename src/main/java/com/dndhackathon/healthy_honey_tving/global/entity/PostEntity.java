package com.dndhackathon.healthy_honey_tving.global.entity;

import com.dndhackathon.healthy_honey_tving.global.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Table(name = "post")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_uid", nullable = false)
    private Long postUID;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_entity_post_uid", referencedColumnName = "post_uid"),
            inverseJoinColumns = @JoinColumn(name = "child_tag_entities_tag_name", referencedColumnName = "tag_name"))
    private List<ChildTagEntity> childTagEntities;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_user_uid", nullable = false)
    private UserEntity author;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "preview_image_url")
    @URL
    private String previewImageUrl;

    public PostDto toDto() {
        return new PostDto(postUID,
                title,
                link,
                description,
                author.getUserUID(),
                childTagEntities.get(0).getParentTag(),
                childTagEntities.stream().map(ChildTagEntity::toDto).collect(Collectors.toList()),
                createdAt, previewImageUrl);
    }
}
