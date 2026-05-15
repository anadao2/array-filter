package com.teste.subarray.domain.port.in;

import com.teste.subarray.application.strategy.LinearSearchStrategy;
import com.teste.subarray.application.usecase.SubarraySearchService;
import com.teste.subarray.domain.model.SearchRequest;
import com.teste.subarray.domain.model.SearchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Contrato: SubarraySearchUseCase")
class SubarraySearchUseCaseContractTest {

    private final SubarraySearchUseCase useCase =
            new SubarraySearchService(new LinearSearchStrategy());

    @Test
    @DisplayName("search() nunca deve retornar null")
    void searchMustNeverReturnNull() {
        SearchRequest request = new SearchRequest(new int[]{1, 2, 3}, new int[]{2});
        assertNotNull(useCase.search(request));
    }

    @Test
    @DisplayName("search() deve retornar isFound=true e posição >= 0 quando target existe")
    void searchMustReturnFoundWithNonNegativePositionWhenTargetExists() {
        SearchResult result = useCase.search(new SearchRequest(new int[]{1, 2, 3}, new int[]{2, 3}));
        assertTrue(result.isFound());
        assertTrue(result.getPosition() >= 0);
    }

    @Test
    @DisplayName("search() deve retornar isFound=false e posição -1 quando target não existe")
    void searchMustReturnNotFoundWithMinusOneWhenTargetAbsent() {
        SearchResult result = useCase.search(new SearchRequest(new int[]{1, 2, 3}, new int[]{4}));
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    @Test
    @DisplayName("search() deve ser idempotente — mesma entrada produz mesmo resultado")
    void searchMustBeIdempotent() {
        SearchRequest request = new SearchRequest(new int[]{0, 2, 3, 5}, new int[]{2, 3});
        SearchResult first = useCase.search(request);
        SearchResult second = useCase.search(request);
        assertEquals(first.getPosition(), second.getPosition());
    }
}
