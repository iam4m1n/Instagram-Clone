package com.Am1n.Instagram_Clone.model.User;

import com.Am1n.Instagram_Clone.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    private UUID userId;

    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(length = 100)
    private String fullName;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String profilePictureUrl;

    @Column(nullable = false)
    private LocalDate joinDate = LocalDate.now();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.PUBLIC;

}
