package com.eight.hundred.group.store.service.impl;

import com.eight.hundred.group.store.dao.entity.Client;
import com.eight.hundred.group.store.dto.request.ClientRequestDTO;
import com.eight.hundred.group.store.dto.response.ClientResponseDTO;
import com.eight.hundred.group.store.mapper.ClientMapper;
import com.eight.hundred.group.store.repository.ClientRepository;
import com.eight.hundred.group.store.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends BaseCRUDService<Long, Client, ClientRequestDTO, ClientResponseDTO> implements ClientService {

    private final ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);
    private final ClientRepository clientRepository;

    @Override
    public Client mapToEntity(ClientRequestDTO clientRequestDTO, Client client) {
        if (client == null)
            client = new Client();
        client.setFirstName(clientRequestDTO.getFirstName());
        client.setLastName(clientRequestDTO.getLastName());
        client.setMobile(clientRequestDTO.getMobile());

        return client;
    }

    @Override
    public ClientResponseDTO mapToResponseDTO(Client client) {
        return clientMapper.toProductResponseDto(client);
    }

    @Override
    public JpaRepository<Client, Long> getRepository() {
        return clientRepository;
    }
}
