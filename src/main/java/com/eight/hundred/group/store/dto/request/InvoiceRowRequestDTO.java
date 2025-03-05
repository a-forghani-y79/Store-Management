package com.eight.hundred.group.store.dto.request;

import com.eight.hundred.group.store.dto.request.base.BaseRequestDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvoiceRowRequestDTO extends BaseRequestDTO {
    @NotNull(message = "invoice.row.request.product-id.not-null")
    private Long productId;

    @Positive(message = "invoice.row.request.quantity.positive")
    private Integer quantity;
}
