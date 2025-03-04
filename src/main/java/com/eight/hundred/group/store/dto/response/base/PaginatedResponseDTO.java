package com.eight.hundred.group.store.dto.response.base;

import com.eight.hundred.group.store.dao.entity.base.BaseEntity;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class PaginatedResponseDTO<T extends BaseResponseDTO> {
    private int page;
    private int size;
    private int totalElements;
    private int totalPages;
    private List<T> data;


    public static <T extends BaseResponseDTO,E extends BaseEntity> PaginatedResponseDTO<T> of(Page<E> page, Function<E, T> mapper) {
        List<T> list = page.get().map(mapper).toList();
        return PaginatedResponseDTO.<T>builder()
                .size(page.getSize())
                .page(page.getNumber())
                .totalElements(page.getNumberOfElements())
                .totalPages(page.getTotalPages())
                .data(list)
                .build();

    }

}
