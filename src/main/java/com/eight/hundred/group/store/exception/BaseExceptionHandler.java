package com.eight.hundred.group.store.exception;

import com.eight.hundred.group.store.dto.response.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponseDTO> httpMessageException(Exception exception, WebRequest request) {
        log.info(exception.getMessage(), exception);
        return toResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), request);

    }

    private ResponseEntity<ErrorResponseDTO> toResponseEntity(HttpStatus httpStatus, String message, WebRequest request) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .code(httpStatus.value())
                .message(message)
                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                .build();
        return new ResponseEntity<>(errorResponseDTO, httpStatus);
    }

}
