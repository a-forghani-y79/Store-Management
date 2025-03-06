package com.eight.hundred.group.store.service.impl;

import com.eight.hundred.group.store.dao.entity.Category;
import com.eight.hundred.group.store.dao.entity.Product;
import com.eight.hundred.group.store.dto.request.ProductRequestDTO;
import com.eight.hundred.group.store.dto.response.ProductResponseDTO;
import com.eight.hundred.group.store.mapper.ProductMapper;
import com.eight.hundred.group.store.repository.ProductRepository;
import com.eight.hundred.group.store.service.CategoryService;
import com.eight.hundred.group.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BaseCRUDService<Long, Product, ProductRequestDTO, ProductResponseDTO> implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);
    private final CategoryService categoryService;

    @Override
    public Product mapToEntity(ProductRequestDTO productRequestDTO, Product product) {
        Category category = categoryService.getEntity(productRequestDTO.getCategoryId());
        if (product == null) {
            product = new Product();
        }
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setStock(productRequestDTO.getStock());

        product.setCategory(category);
        return product;

    }

    @Override
    public ProductResponseDTO mapToResponseDTO(Product product) {
        return productMapper.toProductResponseDto(product);
    }

    @Override
    public JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    public Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    public void decreaseStockOfProduct(Long productId) {
        productRepository.findById(productId).ifPresent(product -> {
            Integer stock = product.getStock();
            product.setStock(stock - 1);
            productRepository.save(product);
        });
    }
}
