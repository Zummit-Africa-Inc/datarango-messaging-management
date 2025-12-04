package com.datarango.messaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.datarango.messaging.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, String> {

}
