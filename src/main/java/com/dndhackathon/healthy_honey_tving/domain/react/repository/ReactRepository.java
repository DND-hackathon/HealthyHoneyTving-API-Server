package com.dndhackathon.healthy_honey_tving.domain.react.repository;

import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import com.dndhackathon.healthy_honey_tving.global.entity.ReactEntity;
import com.dndhackathon.healthy_honey_tving.global.entity.UserEntity;
import com.dndhackathon.healthy_honey_tving.global.enum_type.React;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactRepository extends JpaRepository<ReactEntity, Long> {
    boolean existsAllByPostEntityAndUserEntity(PostEntity postEntity, UserEntity userEntity);
    boolean existsAllByPostEntityAndUserEntityAndReact(PostEntity postEntity, UserEntity userEntity, React react);
    void removeReactEntityByPostEntityAndUserEntity(PostEntity postEntity, UserEntity userEntity);
}
