package com.eight.hundred.group.store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    @Builder.Default
    private Long date = Instant.now().toEpochMilli();
    private String message;
    private Integer code;
    private String path;
}
