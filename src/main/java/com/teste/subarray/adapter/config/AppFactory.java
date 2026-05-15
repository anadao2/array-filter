package com.teste.subarray.adapter.config;

import com.teste.subarray.application.strategy.LinearSearchStrategy;
import com.teste.subarray.application.strategy.SubarraySearchStrategy;
import com.teste.subarray.application.usecase.SubarraySearchService;
import com.teste.subarray.domain.factory.SearchRequestFactory;
import com.teste.subarray.domain.port.in.SubarraySearchUseCase;
import com.teste.subarray.domain.port.out.UniverseRepository;
import com.teste.subarray.domain.validation.RequestValidator;
import com.teste.subarray.domain.validation.SearchRequestValidator;
import com.teste.subarray.infrastructure.repository.InMemoryUniverseRepository;

public class AppFactory {

    private final SubarraySearchUseCase useCase;
    private final SearchRequestFactory requestFactory;
    private final UniverseRepository universeRepository;

    private AppFactory(Builder builder) {
        this.useCase = new SubarraySearchService(builder.strategy);
        this.requestFactory = new SearchRequestFactory(builder.validator);
        this.universeRepository = new InMemoryUniverseRepository(builder.universe);
    }

    public SubarraySearchUseCase getUseCase() {
        return useCase;
    }

    public SearchRequestFactory getRequestFactory() {
        return requestFactory;
    }

    public UniverseRepository getUniverseRepository() {
        return universeRepository;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private SubarraySearchStrategy strategy = new LinearSearchStrategy();
        private RequestValidator validator = new SearchRequestValidator();
        private int[] universe = new int[]{};

        public Builder strategy(SubarraySearchStrategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Builder validator(RequestValidator validator) {
            this.validator = validator;
            return this;
        }

        public Builder universe(int[] universe) {
            this.universe = universe;
            return this;
        }

        public AppFactory build() {
            return new AppFactory(this);
        }
    }
}
