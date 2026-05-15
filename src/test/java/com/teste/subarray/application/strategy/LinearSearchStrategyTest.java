package com.teste.subarray.application.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LinearSearchStrategy")
class LinearSearchStrategyTest {

    private LinearSearchStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new LinearSearchStrategy();
    }

    static Stream<Object[]> searchCases() {
        return Stream.of(
            new Object[]{new int[]{0, 2, 3, 5, 7}, new int[]{3, 5}, 2, "target no meio"},
            new Object[]{new int[]{0, 2, 3, 5, 7}, new int[]{2, 5}, -1, "elementos não contíguos"},
            new Object[]{new int[]{0, 2, 3}, new int[]{0, 2}, 0, "target no início"},
            new Object[]{new int[]{0, 2, 3, 9, 11}, new int[]{9, 11}, 3, "target no fim"},
            new Object[]{new int[]{1, 2, 3}, new int[]{}, 0, "target vazio retorna 0"},
            new Object[]{new int[]{1, 2}, new int[]{1, 2, 3}, -1, "target maior que universo"},
            new Object[]{new int[]{0, 2, 3, 5, 7, 9, 11}, new int[]{7}, 4, "target de um elemento"},
            new Object[]{new int[]{1, 2, 3}, new int[]{1, 2, 3}, 0, "universo igual ao target"}
        );
    }

    @ParameterizedTest(name = "{3}")
    @MethodSource("searchCases")
    @DisplayName("deve retornar a posição correta para cada caso")
    void shouldReturnCorrectPosition(int[] universe, int[] target, int expected, String description) {
        assertEquals(expected, strategy.search(universe, target));
    }

    @Test
    @DisplayName("deve encontrar quando universo e target são a mesma referência")
    void shouldFindWhenUniverseEqualsTargetSameReference() {
        int[] arr = {1, 2, 3};
        assertEquals(0, strategy.search(arr, arr));
    }
}
