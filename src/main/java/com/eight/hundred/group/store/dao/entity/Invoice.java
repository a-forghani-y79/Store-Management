package com.eight.hundred.group.store.dao.entity;


import com.eight.hundred.group.store.dao.entity.base.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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


    @Column(name = "total")
    private BigDecimal total;

}
