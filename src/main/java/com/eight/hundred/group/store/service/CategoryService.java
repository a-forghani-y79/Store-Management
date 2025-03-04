package com.eight.hundred.group.store.service;

import com.eight.hundred.group.store.dao.entity.Category;
import com.eight.hundred.group.store.dto.request.CategoryRequestDTO;
import com.eight.hundred.group.store.dto.response.CategoryResponseDTO;

public interface CategoryService extends CRUDService<Long, Category, CategoryRequestDTO, CategoryResponseDTO> {

}
