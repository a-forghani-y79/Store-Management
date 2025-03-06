package com.eight.hundred.group.store.exception.handler;

import com.eight.hundred.group.store.component.MessageComponent;
import com.eight.hundred.group.store.dto.response.ErrorResponseDTO;
import com.eight.hundred.group.store.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
@RestControllerAdvice
@RequiredArgsConstructor
public class BaseExceptionHandler {

    private final MessageComponent messageComponent;

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponseDTO> httpMessageNotFoundException(MethodArgumentNotValidException methodArgumentNotValidException, WebRequest request) {
        log.debug("validation exception happened : {}", methodArgumentNotValidException.getMessage());
        log.debug(methodArgumentNotValidException.getMessage(), methodArgumentNotValidException);
        FieldError fieldError = methodArgumentNotValidException.getFieldError();

        String message = methodArgumentNotValidException.getDetailMessageCode();
        if (fieldError != null) {
            message = fieldError.getDefaultMessage();
        }
        return toResponseEntity(HttpStatus.BAD_REQUEST, message, request);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponseDTO> httpMessageNotFoundException(NotFoundException notFoundException, WebRequest request) {
        log.warn("not found exception happened with key: {}", notFoundException.getMessageKey());
        String message = messageComponent.getMessage(notFoundException.getMessageKey());
        return toResponseEntity(HttpStatus.NOT_FOUND, message, request);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponseDTO> httpMessageException(Exception exception, WebRequest request) {
        log.error(exception.getMessage(), exception);
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
