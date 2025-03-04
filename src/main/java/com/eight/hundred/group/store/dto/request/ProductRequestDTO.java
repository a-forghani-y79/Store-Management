package com.eight.hundred.group.store.dto.request;

import com.eight.hundred.group.store.dto.request.base.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductRequestDTO extends BaseRequestDTO {

    private String name;
    private String description;
    private BigDecimal price = BigDecimal.ZERO;
    private Integer stock = 0;
    private Long categoryId;

}
