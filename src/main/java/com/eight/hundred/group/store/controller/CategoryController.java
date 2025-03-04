package com.eight.hundred.group.store.controller;


import com.eight.hundred.group.store.controller.base.BaseCRUDController;
import com.eight.hundred.group.store.dao.entity.Category;
import com.eight.hundred.group.store.dto.request.CategoryRequestDTO;
import com.eight.hundred.group.store.dto.response.CategoryResponseDTO;
import com.eight.hundred.group.store.service.CRUDService;
import com.eight.hundred.group.store.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController extends BaseCRUDController<Long, Category, CategoryRequestDTO, CategoryResponseDTO> {


    private final CategoryService categoryService;


    @Override
    public CRUDService<Long, Category, CategoryRequestDTO, CategoryResponseDTO> getCRUDService() {
        return categoryService;
    }

}
