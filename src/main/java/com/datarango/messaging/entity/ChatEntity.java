package com.datarango.messaging.entity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "chats")
@Data
public class ChatEntity {
  @Id
  @Column(name = "id")
  private String id = UUID.randomUUID().toString();

  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false)
  private ChatType type;

  @Column(name = "description")
  private String description;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "is_private", nullable = false)
  private Boolean isPrivate = false;

  @Column(name = "avatar_url")
  private String avatarUrl;

  @Column(name = "last_activity_at", nullable = false)
  private Instant lastActivityAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "created_by_id", nullable = false)
  private String createdBy;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "chat_id")
  private List<PostEntity> posts;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "chat_participants", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<String> participants;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "chat_admins", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<String> admin;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "chat_muted_by", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<String> mutedBy;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pinned_post_id")
  private PostEntity pinnedPost;

  @ElementCollection
  @CollectionTable(name = "chat_tags", joinColumns = @JoinColumn(name = "chat_id"))
  @Column(name = "tag")
  private List<String> tags;

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

  public enum ChatType {
    DIRECT, GROUP
  }
}
