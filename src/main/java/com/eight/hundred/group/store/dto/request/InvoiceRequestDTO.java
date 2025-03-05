package com.eight.hundred.group.store.dto.request;

import com.eight.hundred.group.store.dto.request.base.BaseRequestDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvoiceRequestDTO extends BaseRequestDTO {

    @NotNull(message = "invoice.request.client-id.not-null")
    private Long clientId;

    @NotNull(message = "invoice.request.invoice-rows.not-null")
    private List<InvoiceRowRequestDTO> invoiceRows;

}
