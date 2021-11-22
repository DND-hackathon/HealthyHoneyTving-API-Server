package com.dndhackathon.healthy_honey_tving.domain.react.repository;

import com.dndhackathon.healthy_honey_tving.global.data.entity.PostEntity;
import com.dndhackathon.healthy_honey_tving.global.data.entity.ReactEntity;
import com.dndhackathon.healthy_honey_tving.global.data.entity.UserEntity;
import com.dndhackathon.healthy_honey_tving.global.data.enum_type.React;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactRepository extends JpaRepository<ReactEntity, Long> {
    boolean existsAllByPostEntityAndUserEntity(PostEntity postEntity, UserEntity userEntity);
    boolean existsAllByPostEntityAndUserEntityAndReact(PostEntity postEntity, UserEntity userEntity, React react);
    void removeReactEntityByPostEntityAndUserEntity(PostEntity postEntity, UserEntity userEntity);
}
