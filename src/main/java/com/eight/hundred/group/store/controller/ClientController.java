package com.eight.hundred.group.store.controller;


import com.eight.hundred.group.store.controller.base.BaseCRUDController;
import com.eight.hundred.group.store.dao.entity.Client;
import com.eight.hundred.group.store.dto.request.ClientRequestDTO;
import com.eight.hundred.group.store.dto.response.ClientResponseDTO;
import com.eight.hundred.group.store.service.CRUDService;
import com.eight.hundred.group.store.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController extends BaseCRUDController<Long, Client, ClientRequestDTO, ClientResponseDTO> {

    private final ClientService clientService;

    @Override
    public CRUDService<Long, Client, ClientRequestDTO, ClientResponseDTO> getCRUDService() {
        return clientService;
    }
}
