package io.github.selenklblyva.apiresponsekit.exception;

import io.github.selenklblyva.apiresponsekit.ApiResponse;
import io.github.selenklblyva.apiresponsekit.ErrorDetail;
import io.github.selenklblyva.apiresponsekit.enums.ResponseStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<List<ErrorDetail>>> handleValidation(
            MethodArgumentNotValidException ex) {

        List<ErrorDetail> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> ErrorDetail.builder()
                        .field(e.getField())
                        .message(e.getDefaultMessage())
                        .build())
                .toList();

        return ResponseEntity.badRequest().body(
                ApiResponse.<List<ErrorDetail>>builder()
                        .status(ResponseStatus.BAD_REQUEST)
                        .message("Validation failed")
                        .data(errors)
                        .build()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneral(Exception ex) {
        return ApiResponse.internalError(ex.getMessage());
    }
}