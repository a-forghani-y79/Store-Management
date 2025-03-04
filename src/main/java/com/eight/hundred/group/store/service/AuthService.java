package com.eight.hundred.group.store.service;

import com.eight.hundred.group.store.dto.request.AuthRequestDTO;
import com.eight.hundred.group.store.dto.response.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO login(AuthRequestDTO authRequestDTO);
}
