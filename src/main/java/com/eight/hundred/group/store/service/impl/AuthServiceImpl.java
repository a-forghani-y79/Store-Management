package com.eight.hundred.group.store.service.impl;

import com.eight.hundred.group.store.dao.entity.User;
import com.eight.hundred.group.store.dto.request.AuthRequestDTO;
import com.eight.hundred.group.store.dto.response.AuthResponseDTO;
import com.eight.hundred.group.store.service.AuthService;
import com.eight.hundred.group.store.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthResponseDTO login(AuthRequestDTO authRequestDTO) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(),
                authRequestDTO.getPassword()));
        Object principal = authenticate.getPrincipal();
        User user = (User) principal;
        String jwtToken = jwtService.generateToken(user);

        return AuthResponseDTO.builder().accessToken(jwtToken).expiresIn(jwtService.getExpirationTime()).build();

    }
}
