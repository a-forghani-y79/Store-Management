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
public class InvoiceRowResponseDTO extends BaseResponseDTO {
    private ProductResponseDTO productResponseDTO;
    private Integer quantity;
    private BigDecimal price;
}
