package com.spangles.orgtransportmanagement.util;

public enum HttpStatus {
    SUCCESS(200),
    CREATED(201),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NO_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    REQUEST_TIMEOUT(408),
    INTERNAL_SERVER_ERROR(500),
    BAD_GATEWAY(502),
    SERVICE_UNAVAILABLE(503),
    GATEWAY_TIMEOUT(504);


    private int statusCode;

    HttpStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int statusCode(){
        return this.statusCode;
    }

}
