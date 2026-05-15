package com.teste.subarray.adapter.in.cli;

import com.teste.subarray.domain.factory.SearchRequestFactory;
import com.teste.subarray.domain.model.SearchRequest;
import com.teste.subarray.domain.model.SearchResult;
import com.teste.subarray.domain.port.in.SubarraySearchUseCase;
import com.teste.subarray.domain.port.out.UniverseRepository;

import java.util.Arrays;

public class CliAdapter {

    private final SubarraySearchUseCase useCase;
    private final SearchRequestFactory requestFactory;
    private final UniverseRepository universeRepository;

    public CliAdapter(SubarraySearchUseCase useCase, SearchRequestFactory requestFactory, UniverseRepository universeRepository) {
        this.useCase = useCase;
        this.requestFactory = requestFactory;
        this.universeRepository = universeRepository;
    }

    public void run(int[] target) {
        int[] universe = universeRepository.load();
        SearchRequest request = requestFactory.create(universe, target);
        SearchResult result = useCase.search(request);
        System.out.printf("Universo: %s%n", Arrays.toString(universe));
        System.out.printf("Objetivo: %s%n", Arrays.toString(target));
        System.out.printf("Resultado: %d%n%n", result.getPosition());
    }
}
