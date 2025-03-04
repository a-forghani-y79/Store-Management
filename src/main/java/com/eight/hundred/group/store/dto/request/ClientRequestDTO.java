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
public class ClientRequestDTO extends BaseRequestDTO {

    @NotEmpty(message = "client.request.firstname.not-empty")
    private String firstName;

    @NotEmpty(message = "client.request.lastname.not-empty")
    private String lastName;

    @NotEmpty(message = "client.request.mobile.not-empty")
    private String mobile;
}
