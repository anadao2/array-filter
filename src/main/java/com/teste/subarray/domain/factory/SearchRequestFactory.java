package com.teste.subarray.domain.factory;

import com.teste.subarray.domain.model.SearchRequest;
import com.teste.subarray.domain.validation.RequestValidator;

public class SearchRequestFactory {

    private final RequestValidator validator;

    public SearchRequestFactory(RequestValidator validator) {
        this.validator = validator;
    }

    public SearchRequest create(int[] universe, int[] target) {
        validator.validate(universe, target);
        return new SearchRequest(universe, target);
    }
}
