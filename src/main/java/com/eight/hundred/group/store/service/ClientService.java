package com.eight.hundred.group.store.service;

import com.eight.hundred.group.store.dao.entity.Client;
import com.eight.hundred.group.store.dto.request.ClientRequestDTO;
import com.eight.hundred.group.store.dto.response.ClientResponseDTO;

public interface ClientService extends CRUDService<Long, Client, ClientRequestDTO, ClientResponseDTO> {

}
