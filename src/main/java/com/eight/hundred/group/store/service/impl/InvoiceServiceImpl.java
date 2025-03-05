package com.eight.hundred.group.store.service.impl;

import com.eight.hundred.group.store.dao.entity.Client;
import com.eight.hundred.group.store.dao.entity.Invoice;
import com.eight.hundred.group.store.dao.entity.InvoiceRow;
import com.eight.hundred.group.store.dao.entity.Product;
import com.eight.hundred.group.store.dto.request.InvoiceRequestDTO;
import com.eight.hundred.group.store.dto.request.InvoiceRowRequestDTO;
import com.eight.hundred.group.store.dto.response.InvoiceResponseDTO;
import com.eight.hundred.group.store.service.ClientService;
import com.eight.hundred.group.store.service.InvoiceService;
import com.eight.hundred.group.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl extends BaseCRUDService<Long, Invoice, InvoiceRequestDTO, InvoiceResponseDTO> implements InvoiceService {

    private final ClientService clientService;
    private final ProductService productService;
    private final



    @Override
    public Invoice mapToEntity(InvoiceRequestDTO invoiceRequestDTO, Invoice invoice) {
        if (invoice == null){
            invoice = getRepository().save(new Invoice());
        }
        Invoice finalInvoice = invoice;

        Long clientId = invoiceRequestDTO.getClientId();
        Client client = clientService.getEntity(clientId);

        Set<InvoiceRowRequestDTO> invoiceRowRequestDTOs = invoiceRequestDTO.getInvoiceRows();
        List<InvoiceRow> invoiceRows = invoiceRowRequestDTOs.stream().map(invoiceRowRequestDTO -> {
            Long productId = invoiceRowRequestDTO.getProductId();
            Product product = productService.getEntity(productId);
            InvoiceRow invoiceRow = new InvoiceRow();
            invoiceRow.setProduct(product);
            invoiceRow.setQuantity(invoiceRowRequestDTO.getQuantity());
            invoiceRow.setPrice(product.getPrice());
            invoiceRow.setInvoice(finalInvoice);
            return invoiceRow;
        }).toList();




        invoice.setClient(client);
    }

    @Override
    public InvoiceResponseDTO mapToResponseDTO(Invoice invoice) {
        return null;
    }

    @Override
    public JpaRepository<Invoice, Long> getRepository() {
        return null;
    }
}
