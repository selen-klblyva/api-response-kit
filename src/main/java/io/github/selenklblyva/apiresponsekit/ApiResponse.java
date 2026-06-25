package io.github.selenklblyva.apiresponsekit;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.selenklblyva.apiresponsekit.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private String error;
    private ResponseStatus status;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .status(ResponseStatus.OK)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .status(ResponseStatus.OK)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> error(String error) {
        return ApiResponse.<T>builder()
                .success(false)
                .status(ResponseStatus.INTERNAL_SERVER_ERROR)
                .error(error)
                .build();
    }

    public static <T> ApiResponse<T> error(String message, String error) {
        return ApiResponse.<T>builder()
                .success(false)
                .status(ResponseStatus.INTERNAL_SERVER_ERROR)
                .message(message)
                .error(error)
                .build();
    }

    public static <T> ResponseEntity<ApiResponse<T>> ok(T data) {
        return ResponseEntity.ok(
                ApiResponse.<T>builder()
                        .success(true)
                        .status(ResponseStatus.OK)
                        .message(ResponseStatus.OK.getDefaultMessage())
                        .data(data)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> ok(String message, T data) {
        return ResponseEntity.ok(
                ApiResponse.<T>builder()
                        .success(true)
                        .status(ResponseStatus.OK)
                        .message(message)
                        .data(data)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<T>builder()
                        .success(true)
                        .status(ResponseStatus.CREATED)
                        .message(ResponseStatus.CREATED.getDefaultMessage())
                        .data(data)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(String message, T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<T>builder()
                        .success(true)
                        .status(ResponseStatus.CREATED)
                        .message(message)
                        .data(data)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> notFound(String message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ApiResponse.<T>builder()
                        .success(false)
                        .status(ResponseStatus.NOT_FOUND)
                        .error(message)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> badRequest(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ApiResponse.<T>builder()
                        .success(false)
                        .status(ResponseStatus.BAD_REQUEST)
                        .error(message)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> unauthorized(String message) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                ApiResponse.<T>builder()
                        .success(false)
                        .status(ResponseStatus.UNAUTHORIZED)
                        .error(message)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> forbidden(String message) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                ApiResponse.<T>builder()
                        .success(false)
                        .status(ResponseStatus.FORBIDDEN)
                        .error(message)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> internalError(String message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse.<T>builder()
                        .success(false)
                        .status(ResponseStatus.INTERNAL_SERVER_ERROR)
                        .error(message)
                        .build()
        );
    }
}
