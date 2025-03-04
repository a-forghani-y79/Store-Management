package com.eight.hundred.group.store.service;

import com.eight.hundred.group.store.dao.entity.base.BaseEntity;
import com.eight.hundred.group.store.dto.request.base.BasePaginationRequestDTO;
import com.eight.hundred.group.store.dto.request.base.BaseRequestDTO;
import com.eight.hundred.group.store.dto.response.base.BaseResponseDTO;
import com.eight.hundred.group.store.dto.response.base.PaginatedResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CRUDService<ID, E extends BaseEntity, REQ extends BaseRequestDTO, RES extends BaseResponseDTO> {

    RES create(REQ req);

    RES update(ID id, REQ req);

    RES get(ID id);

    PaginatedResponseDTO<RES> getList(BasePaginationRequestDTO basePaginationRequestDTO);

    void delete(ID id);

    E getEntity(ID id);

    E mapToEntity(REQ req, E e);

    RES mapToResponseDTO(E e);

    JpaRepository<E, ID> getRepository();

}
