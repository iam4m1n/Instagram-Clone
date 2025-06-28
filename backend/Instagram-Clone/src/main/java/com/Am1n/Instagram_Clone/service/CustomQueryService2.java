package com.Am1n.Instagram_Clone.service;

import com.Am1n.Instagram_Clone.model.*;
import com.Am1n.Instagram_Clone.repository.CustomQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class CustomQueryService2 {
    private final CustomQueryRepository repo;
    public List<Post> getLatestPostsFromFollowed(UUID userId) { return repo.getLatestPostsFromFollowed(userId); }
//    public long countFollowers(UUID userId) { return repo.countFollowers(userId); }
    public long countFollowing(UUID userId) { return repo.countFollowing(userId); }
    public List<Object[]> getPostCommentsWithUsernames(UUID postId) { return repo.getPostCommentsWithUsernames(postId); }
    public List<Object[]> getLikeCountPerPost() { return repo.getLikeCountPerPost(); }
    public List<Message> getUnreadMessages(UUID userId) { return repo.getUnreadMessages(userId); }
    public List<Post> getPostsByHashtag(String tag) { return repo.getPostsByHashtag(tag); }
    public List<Object[]> getTopHashtags() { return repo.getTopHashtags(); }
    public List<Post> getNearbyPosts(double lon, double lat) { return repo.getNearbyPosts(lon, lat); }
    public List<Story> getActiveStoriesFromFollowed(UUID userId) { return repo.getActiveStoriesFromFollowed(userId); }
    public List<Object[]> getTopUsersByPostCount() { return repo.getTopUsersByPostCount(); }
    public int markMessagesAsRead(UUID userId) { return repo.markMessagesAsRead(userId); }
    public List<Notification> getUserNotifications(UUID userId) { return repo.getUserNotifications(userId); }
    public List<UserEntity> getUsersWithNoPosts() { return repo.getUsersWithNoPosts(); }
    public Double getAverageCommentsPerPost() { return repo.getAverageCommentsPerPost(); }
}
