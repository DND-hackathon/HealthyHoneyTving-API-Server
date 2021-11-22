package com.dndhackathon.healthy_honey_tving.global.error;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class ErrorResponse {
    private final String message;
    private String doc;
    private final Code code;

    public enum Code {
        NOT_REACT_YET,
        ALREADY_REACTED,
        PERMISSION_DENIED,
        DATA_NOT_FOUND
    }
}
