package com.eight.hundred.group.store.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDTO {
    @NotEmpty(message = "auth.request.user.not-empty")
    private String username;
    @NotEmpty(message = "auth.request.password.not-empty")
    private String password;
}
