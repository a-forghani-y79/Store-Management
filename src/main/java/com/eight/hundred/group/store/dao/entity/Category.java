package com.eight.hundred.group.store.dao.entity;


import com.eight.hundred.group.store.dao.entity.base.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = Category.tableName)
public class Category extends Auditable {

    public static final String tableName = "category";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Product> products;

}
