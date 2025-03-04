package com.eight.hundred.group.store.mapper;

import com.eight.hundred.group.store.dao.entity.Category;
import com.eight.hundred.group.store.dto.response.CategoryResponseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryResponseDTO toCategoryResponseDTO(Category category);
}
