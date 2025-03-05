package com.eight.hundred.group.store.dto.response;


import com.eight.hundred.group.store.dao.enums.UserRole;
import com.eight.hundred.group.store.dto.response.base.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserResponseDTO extends BaseResponseDTO {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String mobile;
    private UserRole role;
}
