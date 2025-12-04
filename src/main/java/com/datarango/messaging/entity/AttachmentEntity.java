package com.datarango.messaging.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "attachments")
@Data
public class AttachmentEntity {
  @Id
  @Column(name = "id")
  private String id = UUID.randomUUID().toString();

  @Column(name = "alt")
  private String alt;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "key", nullable = false)
  private String key;

  @Column(name = "url", nullable = false)
  private String url;

  @Column(name = "mime_type", nullable = false)
  private String mimeType;

  @Column(name = "size", nullable = false)
  private Long size;

  @Column(name = "thumbnail_url")
  private String thumbnailUrl;

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
}