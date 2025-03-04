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
@Table(name = Product.tableName)
public class Product extends Auditable {

    public static final String tableName = "product";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


}
