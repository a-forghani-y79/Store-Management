package com.eight.hundred.group.store.dto.response;

import com.eight.hundred.group.store.dto.response.base.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CategoryResponseDTO extends BaseResponseDTO {
    private String name;
    private String description;
}
