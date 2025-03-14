package com.eight.hundred.group.store.controller;


import com.eight.hundred.group.store.controller.base.BaseCRUDController;
import com.eight.hundred.group.store.dao.entity.Invoice;
import com.eight.hundred.group.store.dto.request.InvoiceRequestDTO;
import com.eight.hundred.group.store.dto.response.InvoiceResponseDTO;
import com.eight.hundred.group.store.service.CRUDService;
import com.eight.hundred.group.store.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController extends BaseCRUDController<Long, Invoice, InvoiceRequestDTO, InvoiceResponseDTO> {

    private final InvoiceService invoiceService;

    @Override
    public CRUDService<Long, Invoice, InvoiceRequestDTO, InvoiceResponseDTO> getCRUDService() {
        return invoiceService;
    }
}
