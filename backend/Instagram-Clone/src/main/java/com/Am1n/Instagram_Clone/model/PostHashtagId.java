package com.Am1n.Instagram_Clone.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class PostHashtagId implements Serializable {
    @Column(name = "post_id")
    private UUID postId;
    @Column(name = "hashtag_id")
    private UUID hashtagId;
}

