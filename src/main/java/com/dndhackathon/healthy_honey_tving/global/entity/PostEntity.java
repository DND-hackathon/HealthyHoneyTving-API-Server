package com.dndhackathon.healthy_honey_tving.global.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "post")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_uid", nullable = false)
    private Long postUID;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_entity_post_uid", referencedColumnName = "post_uid"),
            inverseJoinColumns = @JoinColumn(name = "child_tag_entities_tag_name", referencedColumnName = "tag_name"))
    private List<ChildTagEntity> childTagEntities;

}
