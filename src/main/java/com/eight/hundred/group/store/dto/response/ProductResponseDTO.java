package com.eight.hundred.group.store.dto.response;

import com.eight.hundred.group.store.dto.response.base.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductResponseDTO extends BaseResponseDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private CategoryResponseDTO category;

}
