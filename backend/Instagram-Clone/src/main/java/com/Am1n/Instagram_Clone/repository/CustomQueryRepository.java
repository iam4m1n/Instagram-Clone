package com.Am1n.Instagram_Clone.repository;

import com.Am1n.Instagram_Clone.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomQueryRepository extends JpaRepository<Post, UUID> {

    // 1
    @Query(value = "SELECT p.* FROM post p JOIN follow f ON f.followed_id = p.user_id WHERE f.follower_id = :followerId ORDER BY p.timestamp DESC LIMIT 20", nativeQuery = true)
    List<Post> getLatestPostsFromFollowed(@Param("followerId") UUID followerId);

//    // 2
//    @Query("SELECT COUNT(f) FROM Follow f WHERE f.followed_id = :userId")
//    long countFollowers(@Param("userId") UUID userId);

    // 3
    @Query("SELECT COUNT(f) FROM Follow f WHERE f.follower.userId = :userId")
    long countFollowing(@Param("userId") UUID userId);

    // 4
    @Query(value = "SELECT c.text, c.timestamp, u.username FROM comment c JOIN users u ON u.user_id = c.user_id WHERE c.post_id = :postId ORDER BY c.timestamp ASC", nativeQuery = true)
    List<Object[]> getPostCommentsWithUsernames(@Param("postId") UUID postId);

    // 5
    @Query(value = "SELECT post_id, COUNT(*) AS like_count FROM like GROUP BY post_id ORDER BY like_count DESC", nativeQuery = true)
    List<Object[]> getLikeCountPerPost();

    // 6
    @Query("SELECT m FROM Message m WHERE m.receiver.userId = :userId AND m.seen = false")
    List<Message> getUnreadMessages(@Param("userId") UUID userId);

    // 7
    @Query(value = "SELECT p.* FROM post p JOIN post_hashtag ph ON ph.post_id = p.post_id JOIN hashtag h ON h.hashtag_id = ph.hashtag_id WHERE h.tag = :tag", nativeQuery = true)
    List<Post> getPostsByHashtag(@Param("tag") String tag);

    // 8
    @Query(value = "SELECT h.tag, COUNT(*) AS usage_count FROM post_hashtag ph JOIN hashtag h ON h.hashtag_id = ph.hashtag_id GROUP BY h.tag ORDER BY usage_count DESC LIMIT 5", nativeQuery = true)
    List<Object[]> getTopHashtags();

    // 9
    @Query(value = "SELECT * FROM post WHERE ST_DWithin(location, ST_MakePoint(:lon, :lat)::geography, 10000)", nativeQuery = true)
    List<Post> getNearbyPosts(@Param("lon") double lon, @Param("lat") double lat);

    // 10
    @Query(value = "SELECT s.* FROM story s JOIN follow f ON f.followed_id = s.user_id WHERE f.follower_id = :userId AND s.expiry_time > CURRENT_TIMESTAMP ORDER BY s.timestamp DESC", nativeQuery = true)
    List<Story> getActiveStoriesFromFollowed(@Param("userId") UUID userId);

    // 11
    @Query(value = "SELECT u.username, COUNT(*) AS post_count FROM users u JOIN post p ON u.user_id = p.user_id GROUP BY u.username ORDER BY post_count DESC LIMIT 10", nativeQuery = true)
    List<Object[]> getTopUsersByPostCount();

    // 12
    @Modifying
    @Query("UPDATE Message m SET m.seen = true WHERE m.receiver.userId = :userId AND m.seen = false")
    int markMessagesAsRead(@Param("userId") UUID userId);

    // 13
    @Query("SELECT n FROM Notification n WHERE n.recipient.userId = :userId ORDER BY n.timestamp DESC")
    List<Notification> getUserNotifications(@Param("userId") UUID userId);

    // 14
    @Query(value = "SELECT u.* FROM users u LEFT JOIN post p ON u.user_id = p.user_id WHERE p.post_id IS NULL", nativeQuery = true)
    List<UserEntity> getUsersWithNoPosts();

    // 15
    @Query(value = "SELECT AVG(comment_count)::NUMERIC(10,2) AS avg_comments FROM (SELECT post_id, COUNT(*) AS comment_count FROM comment GROUP BY post_id) AS post_comments", nativeQuery = true)
    Double getAverageCommentsPerPost();
}

