package com.dndhackathon.healthy_honey_tving.global.entity;

import com.dndhackathon.healthy_honey_tving.global.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
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

    @Column(name = "description")
    private String description;

    @Column(name = "link")
    @URL
    private String link;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_entity_post_uid", referencedColumnName = "post_uid"),
            inverseJoinColumns = @JoinColumn(name = "child_tag_entities_tag_name", referencedColumnName = "tag_name"))
    private List<ChildTagEntity> childTagEntities;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_user_uid", nullable = false)
    private UserEntity author;

    public PostDto toDto() {
        return new PostDto(postUID,
                title,
                link,
                description,
                author.getUserUID(),
                childTagEntities.get(0).getParentTag(),
                childTagEntities.stream().map(ChildTagEntity::toDto).collect(Collectors.toList()));
    }
}
