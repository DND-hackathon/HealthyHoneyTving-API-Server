package com.dndhackathon.healthy_honey_tving.global.repository;

import com.dndhackathon.healthy_honey_tving.global.entity.ChildTagEntity;
import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    Page<PostEntity> findAllByChildTagEntitiesContains(ChildTagEntity child, Pageable pageable);
    List<PostEntity> findAllByChildTagEntitiesLike(ChildTagEntity child);
    List<PostEntity> findAllByChildTagEntitiesContains(ChildTagEntity child);
    Page<PostEntity> findAll(Pageable pageable);
}
