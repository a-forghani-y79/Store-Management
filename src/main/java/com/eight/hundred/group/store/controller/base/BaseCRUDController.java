package com.eight.hundred.group.store.controller.base;


import com.eight.hundred.group.store.dao.entity.base.BaseEntity;
import com.eight.hundred.group.store.dto.request.base.BasePaginationRequestDTO;
import com.eight.hundred.group.store.dto.request.base.BaseRequestDTO;
import com.eight.hundred.group.store.dto.response.base.BaseResponseDTO;
import com.eight.hundred.group.store.dto.response.base.PaginatedResponseDTO;
import com.eight.hundred.group.store.service.CRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
public abstract class BaseCRUDController<ID, E extends BaseEntity, REQ extends BaseRequestDTO, RES extends BaseResponseDTO> {

    public abstract CRUDService<ID, E, REQ, RES> getCRUDService();

    @PostMapping("")
    public ResponseEntity<RES> addCategory(@RequestBody REQ req) {
        RES res = getCRUDService().create(req);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RES> getCategoryById(@PathVariable ID id) {
        RES res = getCRUDService().get(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping()
    public ResponseEntity<PaginatedResponseDTO<RES>> getCategories(BasePaginationRequestDTO basePaginationRequestDTO) {
        PaginatedResponseDTO<RES> resPaginatedResponseDTO = getCRUDService().getList(basePaginationRequestDTO);
        return ResponseEntity.ok(resPaginatedResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RES> updateCategory(@PathVariable ID id, @RequestBody REQ req) {
        RES res = getCRUDService().update(id, req);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable ID id) {
        getCRUDService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
