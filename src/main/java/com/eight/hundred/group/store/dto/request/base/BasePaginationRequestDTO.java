package com.eight.hundred.group.store.dto.request.base;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BasePaginationRequestDTO extends BaseRequestDTO {
    @PositiveOrZero(message = "pagination.request.page.positive-or-zero")
    private Integer page;
    @Positive(message = "pagination.request.size.positive")
    private Integer size;
}
