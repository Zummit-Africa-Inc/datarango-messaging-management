package com.datarango.messaging.entity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class PostEntity {
  @Id
  @Column(name = "id")
  private String id = UUID.randomUUID().toString();

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private List<AttachmentEntity> attachments;

  @Column(name = "content", nullable = false, columnDefinition = "TEXT")
  private String content;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private List<CommentEntity> comments;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private List<ReactionEntity> dislikes;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private List<ReactionEntity> likes;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  @Column(name = "edited_at")
  private Instant editedAt;

  @Column(name = "is_pinned", nullable = false)
  private Boolean isPinned = false;

  @Column(name = "is_edited", nullable = false)
  private Boolean isEdited = false;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "post_mentions", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<UserEntity> mentions;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reply_to_id")
  private PostEntity replyTo;

  @ElementCollection
  @CollectionTable(name = "post_tags", joinColumns = @JoinColumn(name = "post_id"))
  @Column(name = "tag")
  private List<String> tags;

  @Column(name = "views", nullable = false)
  private Integer views = 0;

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