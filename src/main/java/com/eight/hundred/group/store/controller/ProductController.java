package com.eight.hundred.group.store.controller;


import com.eight.hundred.group.store.controller.base.BaseCRUDController;
import com.eight.hundred.group.store.dao.entity.Product;
import com.eight.hundred.group.store.dto.request.ProductRequestDTO;
import com.eight.hundred.group.store.dto.response.ProductResponseDTO;
import com.eight.hundred.group.store.service.CRUDService;
import com.eight.hundred.group.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController extends BaseCRUDController<Long, Product, ProductRequestDTO, ProductResponseDTO> {


    private final ProductService productService;

    @Override
    public CRUDService<Long, Product, ProductRequestDTO, ProductResponseDTO> getCRUDService() {
        return productService;
    }
}
