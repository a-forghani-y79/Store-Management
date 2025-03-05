package com.eight.hundred.group.store.mapper;

import com.eight.hundred.group.store.dao.entity.User;
import com.eight.hundred.group.store.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserResponseDTO toProductResponseDto(User user);
}
