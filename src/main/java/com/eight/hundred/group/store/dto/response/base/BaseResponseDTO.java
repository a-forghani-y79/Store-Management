package com.eight.hundred.group.store.dto.response.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDTO {
    private Long id;
    private String createdBy;
    private String modifiedBy;
    private Long createdDate;
    private Long modifiedDate;
}
