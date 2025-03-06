package com.eight.hundred.group.store.dto.request;

import com.eight.hundred.group.store.dto.request.base.BaseRequestDTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserRequestDTO extends BaseRequestDTO {

    @NotEmpty(message = "user.request.username.not-empty")
    private String username;

    @NotEmpty(message = "user.request.firstName.not-empty")
    private String firstName;

    @NotEmpty(message = "user.request.lastName.not-empty")
    private String lastName;

    @NotEmpty(message = "user.request.password.not-empty")
    private String password;

    @NotEmpty(message = "user.request.mobile.not-empty")
    private String mobile;

}
