package com.teste.subarray.application.usecase;

import com.teste.subarray.application.strategy.LinearSearchStrategy;
import com.teste.subarray.domain.model.SearchRequest;
import com.teste.subarray.domain.model.SearchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("SubarraySearchService")
class SubarraySearchServiceTest {

    private SubarraySearchService service;
    private final int[] universe = {0, 2, 3, 5, 7, 9, 11};

    @BeforeEach
    void setUp() {
        service = new SubarraySearchService(new LinearSearchStrategy());
    }

    @Test
    @DisplayName("deve retornar found e posição correta quando target existe")
    void shouldReturnFoundResultWhenTargetExists() {
        SearchResult result = service.search(new SearchRequest(universe, new int[]{3, 5}));
        assertTrue(result.isFound());
        assertEquals(2, result.getPosition());
    }

    @Test
    @DisplayName("deve retornar not found quando target está ausente")
    void shouldReturnNotFoundResultWhenTargetAbsent() {
        SearchResult result = service.search(new SearchRequest(universe, new int[]{2, 5}));
        assertFalse(result.isFound());
    }

    @Test
    @DisplayName("deve retornar found quando target está no início")
    void shouldReturnFoundWhenTargetAtStart() {
        SearchResult result = service.search(new SearchRequest(universe, new int[]{0, 2}));
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    @DisplayName("deve retornar found quando target está no fim")
    void shouldReturnFoundWhenTargetAtEnd() {
        SearchResult result = service.search(new SearchRequest(universe, new int[]{9, 11}));
        assertTrue(result.isFound());
        assertEquals(5, result.getPosition());
    }

    @Test
    @DisplayName("deve retornar found quando universo é igual ao target")
    void shouldReturnFoundWhenUniverseEqualsTarget() {
        SearchResult result = service.search(new SearchRequest(universe, universe));
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    @DisplayName("deve retornar not found quando universo está vazio")
    void shouldReturnNotFoundWhenEmptyUniverse() {
        SearchResult result = service.search(new SearchRequest(new int[]{}, new int[]{1}));
        assertFalse(result.isFound());
    }

    @Test
    @DisplayName("deve lançar NullPointerException quando request é nula")
    void shouldThrowWhenRequestIsNull() {
        assertThrows(NullPointerException.class, () -> service.search(null));
    }

    @Test
    @DisplayName("construtor deve lançar NullPointerException quando strategy é nula")
    void constructorShouldThrowWhenStrategyIsNull() {
        assertThrows(NullPointerException.class, () -> new SubarraySearchService(null));
    }
}
