package com.datarango.messaging.repository;

import org.springframework.stereotype.Repository;
import com.datarango.messaging.entity.AttachmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AttachmentRepository extends JpaRepository<AttachmentEntity, String> {

}
