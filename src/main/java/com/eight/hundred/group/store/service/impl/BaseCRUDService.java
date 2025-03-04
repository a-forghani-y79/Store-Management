package com.eight.hundred.group.store.service.impl;

import com.eight.hundred.group.store.dao.entity.base.BaseEntity;
import com.eight.hundred.group.store.dto.request.base.BasePaginationRequestDTO;
import com.eight.hundred.group.store.dto.request.base.BaseRequestDTO;
import com.eight.hundred.group.store.dto.response.base.BaseResponseDTO;
import com.eight.hundred.group.store.dto.response.base.PaginatedResponseDTO;
import com.eight.hundred.group.store.service.CRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public abstract class BaseCRUDService<ID, E extends BaseEntity, REQ extends BaseRequestDTO, RES extends BaseResponseDTO> implements CRUDService<ID, E, REQ, RES> {


    @Override
    public RES create(REQ req) {
        E entity = mapToEntity(req, null);
        E savedEntity = getRepository().save(entity);
        return mapToResponseDTO(savedEntity);
    }

    @Override
    public RES update(ID id, REQ req) {
        E entity = getRepository().findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));

        entity = mapToEntity(req, entity);
        E updatedEntity = getRepository().save(entity);
        return mapToResponseDTO(updatedEntity);
    }

    @Override
    public RES get(ID id) {
        E entity = getRepository().findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
        return mapToResponseDTO(entity);
    }

    @Override
    public PaginatedResponseDTO<RES> getList(BasePaginationRequestDTO basePaginationRequestDTO) {
        Pageable pageable = PageRequest.of(basePaginationRequestDTO.getPage(), basePaginationRequestDTO.getSize());
        Page<E> page = getRepository().findAll(pageable);
        return PaginatedResponseDTO.of(page, this::mapToResponseDTO);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public E getEntity(ID id) {
        return getRepository().findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
    }
}
