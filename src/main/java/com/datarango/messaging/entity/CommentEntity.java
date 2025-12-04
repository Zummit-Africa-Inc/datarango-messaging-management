package com.datarango.messaging.entity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "comments")
@Data
public class CommentEntity {
  @Id
  @Column(name = "id")
  private String id = UUID.randomUUID().toString();

  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<CommentEntity> comments;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "comment_id")
  private List<ReactionEntity> dislikes;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "comment_id")
  private List<ReactionEntity> likes;

  @Column(name = "user_id", nullable = false)
  private String user;

  @Column(name = "edited_at")
  private Instant editedAt;

  @Column(name = "is_edited", nullable = false)
  private Boolean isEdited = false;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "comment_mentions", joinColumns = @JoinColumn(name = "comment_id"))
  @Column(name = "user_id")
  private List<String> mentions;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reply_to_id")
  private CommentEntity replyTo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  private CommentEntity parent;

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