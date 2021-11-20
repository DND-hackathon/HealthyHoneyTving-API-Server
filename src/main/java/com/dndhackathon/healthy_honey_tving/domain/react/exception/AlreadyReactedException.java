package com.dndhackathon.healthy_honey_tving.domain.react.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlreadyReactedException extends RuntimeException {
    public AlreadyReactedException(String message) {
        super(message);
    }
}
