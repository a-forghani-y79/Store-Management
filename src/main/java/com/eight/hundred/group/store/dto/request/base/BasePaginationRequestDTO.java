package com.eight.hundred.group.store.dto.request.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BasePaginationRequestDTO extends BaseRequestDTO {
    private Integer page;
    private Integer size;
}
