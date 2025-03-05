package com.eight.hundred.group.store.dto.response;

import com.eight.hundred.group.store.dto.response.base.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvoiceResponseDTO extends BaseResponseDTO {
    private ClientResponseDTO client;
    private UserResponseDTO seller;
    private List<InvoiceRowResponseDTO> invoiceRows = new ArrayList<>();
    private BigDecimal total;
}
