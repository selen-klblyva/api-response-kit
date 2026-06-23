package io.github.selenklblyva.apiresponsekit;

import io.github.selenklblyva.apiresponsekit.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private ResponseStatus status;
    private String message;
    private T data;

    public static <T> ResponseEntity<ApiResponse<T>> ok(T data) {
        return ResponseEntity.ok(
                ApiResponse.<T>builder()
                        .status(ResponseStatus.OK)
                        .message("Success")
                        .data(data)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> ok(String message, T data) {
        return ResponseEntity.ok(
                ApiResponse.<T>builder()
                        .status(ResponseStatus.OK)
                        .message(message)
                        .data(data)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<T>builder()
                        .status(ResponseStatus.CREATED)
                        .message("Created successfully")
                        .data(data)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(String message, T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<T>builder()
                        .status(ResponseStatus.CREATED)
                        .message(message)
                        .data(data)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> notFound(String message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ApiResponse.<T>builder()
                        .status(ResponseStatus.NOT_FOUND)
                        .message(message)
                        .data(null)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> badRequest(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ApiResponse.<T>builder()
                        .status(ResponseStatus.BAD_REQUEST)
                        .message(message)
                        .data(null)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> unauthorized(String message) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                ApiResponse.<T>builder()
                        .status(ResponseStatus.UNAUTHORIZED)
                        .message(message)
                        .data(null)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> forbidden(String message) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                ApiResponse.<T>builder()
                        .status(ResponseStatus.FORBIDDEN)
                        .message(message)
                        .data(null)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> internalError(String message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse.<T>builder()
                        .status(ResponseStatus.INTERNAL_SERVER_ERROR)
                        .message(message)
                        .data(null)
                        .build()
        );
    }
}