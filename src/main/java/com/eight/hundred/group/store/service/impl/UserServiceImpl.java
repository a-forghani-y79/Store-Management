package com.eight.hundred.group.store.service.impl;

import com.eight.hundred.group.store.dao.entity.User;
import com.eight.hundred.group.store.dao.enums.UserRole;
import com.eight.hundred.group.store.dto.request.UserRequestDTO;
import com.eight.hundred.group.store.dto.response.UserResponseDTO;
import com.eight.hundred.group.store.mapper.UserMapper;
import com.eight.hundred.group.store.repository.UserRepository;
import com.eight.hundred.group.store.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends BaseCRUDService<Long, User, UserRequestDTO, UserResponseDTO> implements UserService {
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        log.info("init user service");
        log.info("adding admin role user");

        Optional<User> adminUserOptional = userRepository.findByUsername("admin");

        boolean present = adminUserOptional.isPresent();
        if (!present) {
            log.warn("admin user not found");
            log.info("adding new admin user");
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setMobile("09000000000");
            user.setRole(UserRole.ADMIN);
            userRepository.save(user);
        } else {
            log.warn("admin user already exists");
        }
    }

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
        user.setRole(UserRole.SELLER);
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
