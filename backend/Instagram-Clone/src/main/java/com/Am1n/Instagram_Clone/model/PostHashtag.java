package com.Am1n.Instagram_Clone.model;

import jakarta.persistence.*;

@Entity
public class PostHashtag {

    @EmbeddedId
    private PostHashtagId id;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @MapsId("hashtagId")
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;
}

