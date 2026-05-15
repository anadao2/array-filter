package com.teste.subarray.application.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Contrato: SubarraySearchStrategy")
class SubarraySearchStrategyContractTest {

    private final SubarraySearchStrategy strategy = new LinearSearchStrategy();

    @Test
    @DisplayName("search() deve retornar >= 0 quando target está contido no universo")
    void searchMustReturnNonNegativeWhenFound() {
        int result = strategy.search(new int[]{1, 2, 3, 4}, new int[]{2, 3});
        assertTrue(result >= 0);
    }

    @Test
    @DisplayName("search() deve retornar -1 quando target não está contido")
    void searchMustReturnMinusOneWhenNotFound() {
        assertEquals(-1, strategy.search(new int[]{1, 2, 3}, new int[]{4, 5}));
    }

    @Test
    @DisplayName("search() deve retornar 0 para target vazio")
    void searchMustReturnZeroForEmptyTarget() {
        assertEquals(0, strategy.search(new int[]{1, 2, 3}, new int[]{}));
    }

    @Test
    @DisplayName("search() deve retornar -1 quando target é maior que universo")
    void searchMustReturnMinusOneWhenTargetLargerThanUniverse() {
        assertEquals(-1, strategy.search(new int[]{1}, new int[]{1, 2}));
    }

    @Test
    @DisplayName("search() deve ser determinístico — mesma entrada, mesmo resultado")
    void searchMustBeDeterministic() {
        int[] universe = {0, 2, 3, 5, 7};
        int[] target = {3, 5};
        assertEquals(strategy.search(universe, target), strategy.search(universe, target));
    }
}
