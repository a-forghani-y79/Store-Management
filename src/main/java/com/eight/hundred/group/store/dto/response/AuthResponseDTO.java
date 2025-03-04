package com.eight.hundred.group.store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private String accessToken;
    private Long expiresIn;
    private final String tokenType = "Bearer";
}
