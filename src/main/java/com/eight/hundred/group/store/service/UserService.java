package com.eight.hundred.group.store.service;

import com.eight.hundred.group.store.dao.entity.User;
import com.eight.hundred.group.store.dto.request.UserRequestDTO;
import com.eight.hundred.group.store.dto.response.UserResponseDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, CRUDService<Long, User, UserRequestDTO, UserResponseDTO> {
}
