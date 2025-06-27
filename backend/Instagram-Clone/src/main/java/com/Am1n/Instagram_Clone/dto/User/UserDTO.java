package com.Am1n.Instagram_Clone.dto.User;
import java.util.UUID;

import lombok.Data;

@Data
public class UserDTO {
    private UUID userId;
    private String username;
    private String email;
    private String fullName;
    private String profilePictureUrl;
    // Exclude sensitive fields like password
}
