package com.eight.hundred.group.store.repository;

import com.eight.hundred.group.store.dao.entity.InvoiceRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRowRepository extends JpaRepository<InvoiceRow, Long> {
}
