package com.Am1n.Instagram_Clone.model.PostHashtag;

import com.Am1n.Instagram_Clone.model.Hashtag.Hashtag;
import com.Am1n.Instagram_Clone.model.Post.Post;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class PostHashtag {

    @EmbeddedId
    private PostHashtagId id;

    @ManyToOne
    @MapsId("postId")
    private Post post;

    @ManyToOne
    @MapsId("hashtagId")
    private Hashtag hashtag;
}

