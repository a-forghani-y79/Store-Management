package com.eight.hundred.group.store.controller;


import com.eight.hundred.group.store.controller.base.BaseCRUDController;
import com.eight.hundred.group.store.dao.entity.InvoiceRow;
import com.eight.hundred.group.store.dto.request.InvoiceRowRequestDTO;
import com.eight.hundred.group.store.dto.response.InvoiceRowResponseDTO;
import com.eight.hundred.group.store.service.CRUDService;
import com.eight.hundred.group.store.service.InvoiceRowService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/invoice-rows")
@RequiredArgsConstructor
public class InvoiceRowController extends BaseCRUDController<Long, InvoiceRow, InvoiceRowRequestDTO, InvoiceRowResponseDTO> {

    private final InvoiceRowService invoiceRowService;

    @Override
    public CRUDService<Long, InvoiceRow, InvoiceRowRequestDTO, InvoiceRowResponseDTO> getCRUDService() {
        return invoiceRowService;
    }
}
