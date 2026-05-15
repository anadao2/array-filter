package com.teste.subarray.domain.validation;

import com.teste.subarray.domain.exception.InvalidSearchRequestException;

public class SearchRequestValidator implements RequestValidator {

    @Override
    public void validate(int[] universe, int[] target) {
        if (universe == null) {
            throw new InvalidSearchRequestException("universe não pode ser nulo");
        }
        if (target == null) {
            throw new InvalidSearchRequestException("target não pode ser nulo");
        }
    }
}
