package com.datarango.messaging.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reactions")
@Data
public class ReactionEntity {
  @Id
  @Column(name = "id")
  private String id = UUID.randomUUID().toString();

  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false)
  private ReactionType type;

  @Column(name = "user_id", nullable = false)
  private String user;

  @Column(name = "created_at", nullable = false)
  private Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

  @PrePersist
  protected void onCreate() {
    Instant now = Instant.now();
    if (createdAt == null)
      createdAt = now;
    updatedAt = now;
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = Instant.now();
  }

  public enum ReactionType {
    DISLIKE, LIKE
  }
}