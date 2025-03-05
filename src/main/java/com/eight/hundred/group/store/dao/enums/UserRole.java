package com.eight.hundred.group.store.dao.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    ADMIN("admin"),
    SELLER("seller");

    private final String name;
}
