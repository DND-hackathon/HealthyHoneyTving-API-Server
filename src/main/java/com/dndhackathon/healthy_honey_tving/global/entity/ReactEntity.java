package com.dndhackathon.healthy_honey_tving.global.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "react")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relation_uid", nullable = false)
    private Long relationUID;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_entity_user_uid")
    private UserEntity userEntity;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_entity_post_uid")
    private PostEntity postEntity;


    @Enumerated(EnumType.STRING)
    @Column(name = "react", nullable = false)
    private com.dndhackathon.healthy_honey_tving.global.enum_type.React react;

}