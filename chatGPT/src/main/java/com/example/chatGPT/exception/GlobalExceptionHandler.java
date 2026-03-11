package com.example.chatGPT.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

@ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handle(EmployeeNotFoundException ex, WebRequest request){
log.error("Employee not found");
final ErrorResponseDTO responseDTO=ErrorResponseDTO.builder()
        .code("EXCPTION-001")
        .message("Not Found Employee")
        .time(LocalDateTime.now())
        .status(404)
        .path(((ServletWebRequest)request).getRequest().getRequestURI())
        .build();
return ResponseEntity.status(404).body(responseDTO);
}

}

