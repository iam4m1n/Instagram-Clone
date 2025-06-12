package com.Am1n.Instagram_Clone.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class PostHashtagId implements Serializable {
    private UUID postId;
    private UUID hashtagId;
}

