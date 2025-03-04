package com.eight.hundred.group.store.dao.entity;

import com.eight.hundred.group.store.dao.entity.base.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = Client.tableName)
public class Client extends Auditable {

    public static final String tableName = "client";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Invoice> invoices = new HashSet<>();


}
