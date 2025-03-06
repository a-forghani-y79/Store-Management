package com.eight.hundred.group.store.exception;

import com.eight.hundred.group.store.dao.entity.base.BaseEntity;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private static final String notFoundMessageKey = ".not-found";

    private final String messageKey;
    private final Class<? extends BaseEntity> entityClass;

    public <E extends BaseEntity> NotFoundException(Class<E> clazz) {
        super();
        String clazzName = clazz.getSimpleName().toLowerCase();
        this.messageKey = clazzName.concat(notFoundMessageKey);
        this.entityClass = clazz;
    }
}
