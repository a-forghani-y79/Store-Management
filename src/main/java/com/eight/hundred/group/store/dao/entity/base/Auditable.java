package com.eight.hundred.group.store.dao.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;


@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class Auditable extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_date")
    protected Long createdDate = 0L;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "modified_date")
    protected Long modifiedDate = 0L;

    @Column(name = "created_by")
    @CreatedBy
    protected String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    protected String modifiedBy;
}
