package com.eight.hundred.group.store.service.impl;

import com.eight.hundred.group.store.dao.entity.Client;
import com.eight.hundred.group.store.dao.entity.Invoice;
import com.eight.hundred.group.store.dao.entity.InvoiceRow;
import com.eight.hundred.group.store.dao.entity.User;
import com.eight.hundred.group.store.dto.request.InvoiceRequestDTO;
import com.eight.hundred.group.store.dto.request.InvoiceRowRequestDTO;
import com.eight.hundred.group.store.dto.response.InvoiceResponseDTO;
import com.eight.hundred.group.store.mapper.InvoiceMapper;
import com.eight.hundred.group.store.repository.InvoiceRepository;
import com.eight.hundred.group.store.service.ClientService;
import com.eight.hundred.group.store.service.InvoiceRowService;
import com.eight.hundred.group.store.service.InvoiceService;
import com.eight.hundred.group.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl extends BaseCRUDService<Long, Invoice, InvoiceRequestDTO, InvoiceResponseDTO> implements InvoiceService {

    private final ClientService clientService;

    private final InvoiceRowService invoiceRowService;
    private final ProductService productService;

    private final InvoiceRepository invoiceRepository;

    private final InvoiceMapper invoiceMapper = Mappers.getMapper(InvoiceMapper.class);

    @Override
    public Invoice mapToEntity(InvoiceRequestDTO invoiceRequestDTO, Invoice invoice) {

        Long clientId = invoiceRequestDTO.getClientId();
        Client client = clientService.getEntity(clientId);
        User currentUser = getCurrentUser();

        if (invoice == null) {
            invoice = new Invoice();
        }

        invoice.setClient(client);
        invoice.setSeller(currentUser);
        invoice = getRepository().save(invoice);

        Invoice finalInvoice = invoice;

        List<InvoiceRowRequestDTO> invoiceRowRequestDTOs = invoiceRequestDTO.getInvoiceRows();
        List<InvoiceRow> invoiceRows = invoiceRowRequestDTOs.stream().map(invoiceRowRequestDTO -> {
            InvoiceRow invoiceRow = invoiceRowService.mapToEntity(invoiceRowRequestDTO, null);
            invoiceRow.setInvoice(finalInvoice);
            return invoiceRow;
        }).toList();
        invoiceRows = invoiceRowService.getRepository().saveAll(invoiceRows);
        invoice.addAllInvoiceRows(invoiceRows);

        long sumInvoiceRoes = invoice.getInvoiceRows().stream()
                .peek(invoiceRow -> productService.decreaseStockOfProduct(invoiceRow.getProduct().getId()))
                .mapToLong(invoiceRow ->
                        invoiceRow.getPrice().multiply(BigDecimal.valueOf(invoiceRow.getQuantity())).longValue())
                .sum();
        invoice.setTotal(BigDecimal.valueOf(sumInvoiceRoes));
        return invoice;
    }

    @Override
    public InvoiceResponseDTO mapToResponseDTO(Invoice invoice) {
        return invoiceMapper.toInvoiceResponseDto(invoice);
    }

    @Override
    public JpaRepository<Invoice, Long> getRepository() {
        return invoiceRepository;
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        return ((User) principal);
    }
}
