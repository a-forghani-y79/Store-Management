package com.eight.hundred.group.store.dto.request;

import com.eight.hundred.group.store.dto.request.base.BaseRequestDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestDTO extends BaseRequestDTO {
    @NotEmpty(message = "category.request.name.not-empty")
    private String name;

    @Size(max = 250, message = "category.request.description.max-length")
    private String description;
}
