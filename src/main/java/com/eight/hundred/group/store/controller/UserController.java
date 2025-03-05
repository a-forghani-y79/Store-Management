package com.eight.hundred.group.store.controller;


import com.eight.hundred.group.store.controller.base.BaseCRUDController;
import com.eight.hundred.group.store.dao.entity.User;
import com.eight.hundred.group.store.dto.request.UserRequestDTO;
import com.eight.hundred.group.store.dto.response.UserResponseDTO;
import com.eight.hundred.group.store.service.CRUDService;
import com.eight.hundred.group.store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController extends BaseCRUDController<Long, User, UserRequestDTO, UserResponseDTO> {

    private final UserService userService;

    @Override
    public CRUDService<Long, User, UserRequestDTO, UserResponseDTO> getCRUDService() {
        return userService;
    }
}
