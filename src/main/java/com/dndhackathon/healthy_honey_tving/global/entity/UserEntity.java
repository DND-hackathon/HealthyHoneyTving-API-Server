package com.dndhackathon.healthy_honey_tving.global.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "user")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_uid", nullable = false)
    private Long userUID;

}