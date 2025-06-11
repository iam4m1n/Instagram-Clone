package com.Am1n.Instagram_Clone.model.Hashtag;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "hashtags",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hashtag {

    @Id
    @GeneratedValue
    private UUID hashtagId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
}

