package com.eight.hundred.group.store.service;

import com.eight.hundred.group.store.dao.entity.Product;
import com.eight.hundred.group.store.dto.request.ProductRequestDTO;
import com.eight.hundred.group.store.dto.response.ProductResponseDTO;

public interface ProductService extends CRUDService<Long, Product, ProductRequestDTO, ProductResponseDTO> {

}
