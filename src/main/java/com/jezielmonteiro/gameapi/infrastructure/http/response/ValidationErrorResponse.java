package com.jezielmonteiro.gameapi.infrastructure.http.response;

import java.time.Instant;
import java.util.List;

public record ValidationErrorResponse(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path,
        List errors
) {
    public record Violation(String field, String message) {
    }
}