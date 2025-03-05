package com.eight.hundred.group.store.service;

import com.eight.hundred.group.store.dao.entity.Invoice;
import com.eight.hundred.group.store.dto.request.InvoiceRequestDTO;
import com.eight.hundred.group.store.dto.response.InvoiceResponseDTO;

public interface InvoiceService extends CRUDService<Long, Invoice, InvoiceRequestDTO, InvoiceResponseDTO> {
}
