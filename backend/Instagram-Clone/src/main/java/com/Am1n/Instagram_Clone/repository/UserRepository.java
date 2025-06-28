package com.Am1n.Instagram_Clone.repository;
import com.Am1n.Instagram_Clone.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    // Simulated in-memory storage
    public default String findBioByUserId(UUID id) { return "Sample bio for: " + id; }
}