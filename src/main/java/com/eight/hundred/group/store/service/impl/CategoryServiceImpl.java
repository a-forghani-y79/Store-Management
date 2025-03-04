package com.eight.hundred.group.store.service.impl;

import com.eight.hundred.group.store.dao.entity.Category;
import com.eight.hundred.group.store.dto.request.CategoryRequestDTO;
import com.eight.hundred.group.store.dto.response.CategoryResponseDTO;
import com.eight.hundred.group.store.mapper.CategoryMapper;
import com.eight.hundred.group.store.repository.CategoryRepository;
import com.eight.hundred.group.store.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends BaseCRUDService<Long, Category, CategoryRequestDTO, CategoryResponseDTO> implements CategoryService {
    private final CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);
    private final CategoryRepository categoryRepository;

    @Override
    public Category mapToEntity(CategoryRequestDTO categoryRequestDTO, Category category) {
        if (category == null) {
            category = new Category();
        }
        category.setName(categoryRequestDTO.getName());
        category.setDescription(categoryRequestDTO.getDescription());
        return null;
    }

    @Override
    public CategoryResponseDTO mapToResponseDTO(Category category) {
        return categoryMapper.toCategoryResponseDTO(category);
    }

    @Override
    public JpaRepository<Category, Long> getRepository() {
        return categoryRepository;
    }

    @Override
    public void delete(Long aLong) {
        Category category = super.getEntity(aLong);
        if (!category.getProducts().isEmpty()) {
            throw new RuntimeException("category has usages");
        }
        super.delete(aLong);
    }
}
