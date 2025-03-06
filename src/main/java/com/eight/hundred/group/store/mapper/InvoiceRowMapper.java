package com.eight.hundred.group.store.mapper;

import com.eight.hundred.group.store.dao.entity.InvoiceRow;
import com.eight.hundred.group.store.dto.response.InvoiceRowResponseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface InvoiceRowMapper {
    InvoiceRowResponseDTO toInvoiceRowResponseDto(InvoiceRow invoiceRow);
}
