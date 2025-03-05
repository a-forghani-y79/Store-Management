package com.eight.hundred.group.store.service.impl;

import com.eight.hundred.group.store.dao.entity.InvoiceRow;
import com.eight.hundred.group.store.dao.entity.Product;
import com.eight.hundred.group.store.dto.request.InvoiceRowRequestDTO;
import com.eight.hundred.group.store.dto.response.InvoiceRowResponseDTO;
import com.eight.hundred.group.store.mapper.InvoiceRowMapper;
import com.eight.hundred.group.store.repository.InvoiceRowRepository;
import com.eight.hundred.group.store.service.InvoiceRowService;
import com.eight.hundred.group.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceRowServiceImpl extends BaseCRUDService<Long, InvoiceRow, InvoiceRowRequestDTO, InvoiceRowResponseDTO> implements InvoiceRowService {

    private final InvoiceRowMapper invoiceRowMapper = Mappers.getMapper(InvoiceRowMapper.class);
    private final InvoiceRowRepository invoiceRowRepository;
    private final ProductService productService;

    @Override
    public InvoiceRow mapToEntity(InvoiceRowRequestDTO invoiceRowRequestDTO, InvoiceRow invoiceRow) {
        if (invoiceRow == null)
            invoiceRow = new InvoiceRow();

        Product product = productService.getEntity(invoiceRowRequestDTO.getProductId());

        invoiceRow.setQuantity(invoiceRowRequestDTO.getQuantity());
        invoiceRow.setProduct(product);
        invoiceRow.setPrice(product.getPrice());

        return invoiceRow;
    }

    @Override
    public InvoiceRowResponseDTO mapToResponseDTO(InvoiceRow invoiceRow) {
        return invoiceRowMapper.toInvoiceRowResponseDto(invoiceRow);
    }

    @Override
    public JpaRepository<InvoiceRow, Long> getRepository() {
        return invoiceRowRepository;
    }
}
