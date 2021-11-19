package com.dndhackathon.healthy_honey_tving.global.entity;

import com.dndhackathon.healthy_honey_tving.global.dto.ChildTagDto;
import com.dndhackathon.healthy_honey_tving.global.enum_type.ParentTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "child_tag")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChildTagEntity {
    @Id
    @Column(name = "tag_name", nullable = false)
    private String tagName;

    @Enumerated(EnumType.STRING)
    @Column(name = "parent_tag", nullable = false)
    private ParentTag parentTag;

    public ChildTagDto toDto() {
        return new ChildTagDto(tagName, parentTag);
    }
}