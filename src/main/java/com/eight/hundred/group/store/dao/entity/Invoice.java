package com.eight.hundred.group.store.dao.entity;


import com.eight.hundred.group.store.dao.entity.base.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = Invoice.tableName)
public class Invoice extends Auditable {

    public static final String tableName = "invoice";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "invoice")
    private List<InvoiceRow> invoiceRows = new ArrayList<>();

    public void addAllInvoiceRows(Collection<InvoiceRow> invoiceRows) {
        this.invoiceRows.addAll(invoiceRows);
    }

    @Column(name = "total")
    private BigDecimal total;

}
