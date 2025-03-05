package com.eight.hundred.group.store.mapper;

import com.eight.hundred.group.store.dao.entity.Invoice;
import com.eight.hundred.group.store.dao.entity.InvoiceRow;
import com.eight.hundred.group.store.dto.response.InvoiceResponseDTO;
import com.eight.hundred.group.store.dto.response.InvoiceRowResponseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface InvoiceMapper {
    InvoiceResponseDTO toInvoiceResponseDto(Invoice invoice);
}
