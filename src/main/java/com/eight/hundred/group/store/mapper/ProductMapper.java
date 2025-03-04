package com.eight.hundred.group.store.mapper;

import com.eight.hundred.group.store.dao.entity.Product;
import com.eight.hundred.group.store.dto.response.ProductResponseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductResponseDTO toProductResponseDto(Product product);
}
