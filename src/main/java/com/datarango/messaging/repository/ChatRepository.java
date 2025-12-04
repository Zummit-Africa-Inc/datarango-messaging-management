package com.datarango.messaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datarango.messaging.entity.ChatEntity;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, String> {

}
