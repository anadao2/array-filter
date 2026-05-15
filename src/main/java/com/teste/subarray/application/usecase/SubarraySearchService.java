package com.teste.subarray.application.usecase;

import com.teste.subarray.application.strategy.SubarraySearchStrategy;
import com.teste.subarray.domain.model.SearchRequest;
import com.teste.subarray.domain.model.SearchResult;
import com.teste.subarray.domain.port.in.SubarraySearchUseCase;

import java.util.Objects;

public class SubarraySearchService implements SubarraySearchUseCase {

    private final SubarraySearchStrategy strategy;

    public SubarraySearchService(SubarraySearchStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "strategy não pode ser nula");
    }

    @Override
    public SearchResult search(SearchRequest request) {
        Objects.requireNonNull(request, "request não pode ser nula");
        int position = strategy.search(request.getUniverse(), request.getTarget());
        return position >= 0 ? SearchResult.found(position) : SearchResult.notFound();
    }
}
