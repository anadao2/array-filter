package com.teste.subarray.domain.exception;

public class InvalidSearchRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidSearchRequestException(String message) {
        super(message);
    }
}
