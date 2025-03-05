package com.eight.hundred.group.store.service;

import com.eight.hundred.group.store.dao.entity.InvoiceRow;
import com.eight.hundred.group.store.dto.request.InvoiceRowRequestDTO;
import com.eight.hundred.group.store.dto.response.InvoiceRowResponseDTO;

public interface InvoiceRowService extends CRUDService<Long, InvoiceRow, InvoiceRowRequestDTO, InvoiceRowResponseDTO> {

}
