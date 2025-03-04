package com.eight.hundred.group.store.dto.response.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDTO {
    private String createBy;
    private String updateBy;
    private Date createDate;
    private Date updateDate;
}
