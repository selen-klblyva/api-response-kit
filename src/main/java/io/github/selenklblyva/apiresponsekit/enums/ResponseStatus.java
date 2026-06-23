package io.github.selenklblyva.apiresponsekit.enums;

import lombok.Getter;

@Getter
public enum ResponseStatus {
    OK(200,"Success"),
    CREATED(201,"Created successfully"),
    BAD_REQUEST(400,"Bad Request"),
    UNAUTHORIZED(401,"Unauthorized"),
    FORBIDDEN(403,"Forbidden"),
    NOT_FOUND(404,"Not Found"),
    INTERNAL_SERVER_ERROR(500,"Internal Server Error");

    private final int code;
    private final String defaultMessage;

    ResponseStatus(int code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }
}
