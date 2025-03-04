package com.eight.hundred.group.store.mapper;

import com.eight.hundred.group.store.dao.entity.Client;
import com.eight.hundred.group.store.dto.response.ClientResponseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {
    ClientResponseDTO toProductResponseDto(Client client);
}
