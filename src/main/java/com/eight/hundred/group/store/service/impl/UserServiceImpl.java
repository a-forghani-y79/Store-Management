package com.eight.hundred.group.store.service.impl;

import com.eight.hundred.group.store.dao.entity.User;
import com.eight.hundred.group.store.dto.request.UserRequestDTO;
import com.eight.hundred.group.store.dto.response.UserResponseDTO;
import com.eight.hundred.group.store.mapper.UserMapper;
import com.eight.hundred.group.store.repository.UserRepository;
import com.eight.hundred.group.store.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends BaseCRUDService<Long, User, UserRequestDTO, UserResponseDTO> implements UserService {
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public User mapToEntity(UserRequestDTO userRequestDTO, User user) {
        if (user == null) {
            user = new User();
        }
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(userRequestDTO.getPassword());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setMobile(userRequestDTO.getMobile());
        return user;
    }

    @Override
    public UserResponseDTO mapToResponseDTO(User user) {
        return userMapper.toProductResponseDto(user);
    }

    @Override
    public JpaRepository<User, Long> getRepository() {
        return userRepository;
    }
}
