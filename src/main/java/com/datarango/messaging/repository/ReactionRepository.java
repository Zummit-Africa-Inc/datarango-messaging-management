package com.datarango.messaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.datarango.messaging.entity.ReactionEntity;

@Repository
public interface ReactionRepository extends JpaRepository<ReactionEntity, String> {

}
