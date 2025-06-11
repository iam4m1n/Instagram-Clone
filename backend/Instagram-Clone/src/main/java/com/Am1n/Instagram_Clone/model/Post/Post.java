package com.Am1n.Instagram_Clone.model.Post;

import com.Am1n.Instagram_Clone.model.User.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue
    private UUID postId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(columnDefinition = "TEXT")
    private String caption;

    @Column(nullable = false)
    private String imageUrl;

    @CreationTimestamp
    private Instant timestamp;

    /**
     * PostGIS location: make sure PostgreSQL has PostGIS installed.
     */
    @Column(columnDefinition = "GEOGRAPHY(POINT, 4326)")
    private Point location;
}
