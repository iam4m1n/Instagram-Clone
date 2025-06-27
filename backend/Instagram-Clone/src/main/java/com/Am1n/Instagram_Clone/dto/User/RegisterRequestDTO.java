package com.Am1n.Instagram_Clone.dto.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequestDTO {

    @NotBlank
    @Size(min = 3, max = 30)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;

    // Getters and Setters
}
