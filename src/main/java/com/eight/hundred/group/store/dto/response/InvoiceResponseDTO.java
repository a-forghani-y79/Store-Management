package com.eight.hundred.group.store.dto.response;

import com.eight.hundred.group.store.dto.response.base.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvoiceResponseDTO extends BaseResponseDTO {

    private Long id;
    private ClientResponseDTO client;
    private UserResponseDTO seller;
    private Set<InvoiceRowResponseDTO> invoiceRows = new HashSet<>();
    private BigDecimal total;
}
