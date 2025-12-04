package com.datarango.messaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.datarango.messaging.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, String> {

}
