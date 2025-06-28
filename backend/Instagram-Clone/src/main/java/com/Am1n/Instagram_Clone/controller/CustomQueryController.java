package com.Am1n.Instagram_Clone.controller;

import com.Am1n.Instagram_Clone.TestService;
import com.Am1n.Instagram_Clone.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/queries")
@RequiredArgsConstructor
class CustomQueryController {
    private final TestService service;

    @GetMapping("/latest-followed-posts/{userId}")
    public List<Post> latestPosts(@PathVariable UUID userId) { return service.getLatestPostsFromFollowed(userId); }

//    @GetMapping("/followers-count/{userId}")
//    public long followerCount(@PathVariable UUID userId) { return service.countFollowers(userId); }

    @GetMapping("/following-count/{userId}")
    public long followingCount(@PathVariable UUID userId) { return service.countFollowing(userId); }

    @GetMapping("/post-comments/{postId}")
    public List<Object[]> postComments(@PathVariable UUID postId) { return service.getPostCommentsWithUsernames(postId); }

    @GetMapping("/like-counts")
    public List<Object[]> likeCounts() { return service.getLikeCountPerPost(); }

    @GetMapping("/unread-messages/{userId}")
    public List<Message> unreadMessages(@PathVariable UUID userId) { return service.getUnreadMessages(userId); }

    @GetMapping("/posts-by-hashtag")
    public List<Post> postsByHashtag(@RequestParam String tag) { return service.getPostsByHashtag(tag); }

    @GetMapping("/top-hashtags")
    public List<Object[]> topHashtags() { return service.getTopHashtags(); }

    @GetMapping("/nearby-posts")
    public List<Post> nearbyPosts(@RequestParam double lon, @RequestParam double lat) { return service.getNearbyPosts(lon, lat); }

    @GetMapping("/active-stories/{userId}")
    public List<Story> activeStories(@PathVariable UUID userId) { return service.getActiveStoriesFromFollowed(userId); }

    @GetMapping("/top-posters")
    public List<Object[]> topUsers() { return service.getTopUsersByPostCount(); }

    @PostMapping("/mark-messages-read/{userId}")
    public int markMessagesRead(@PathVariable UUID userId) { return service.markMessagesAsRead(userId); }

    @GetMapping("/notifications/{userId}")
    public List<Notification> notifications(@PathVariable UUID userId) { return service.getUserNotifications(userId); }

    @GetMapping("/users-without-posts")
    public List<UserEntity> noPostUsers() { return service.getUsersWithNoPosts(); }

    @GetMapping("/average-comments")
    public Double avgComments() { return service.getAverageCommentsPerPost(); }
}
