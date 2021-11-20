package com.dndhackathon.healthy_honey_tving.domain.post.repository;

import com.dndhackathon.healthy_honey_tving.global.entity.ChildTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildTagRepository extends JpaRepository<ChildTagEntity, Long> {
}
