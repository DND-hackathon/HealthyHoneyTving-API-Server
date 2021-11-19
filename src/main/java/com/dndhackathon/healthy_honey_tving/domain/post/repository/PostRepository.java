package com.dndhackathon.healthy_honey_tving.domain.post.repository;

import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    public List<PostEntity> findAllByChildTagEntitiesContains(String child);
}
