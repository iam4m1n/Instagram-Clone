package com.Am1n.Instagram_Clone.model.Story;

import com.Am1n.Instagram_Clone.model.User.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "stories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Story {

    @Id
    @GeneratedValue
    private UUID storyId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String imageUrl;

    @CreationTimestamp
    private Instant timestamp;

    @Column(nullable = false)
    private Instant expiresAt;

    private boolean seen = false;
}

