package com.teste.subarray.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("SearchResult")
class SearchResultTest {

    @Test
    @DisplayName("found() deve retornar isFound=true e a posição correta")
    void foundMustReturnIsFFoundTrueAndCorrectPosition() {
        SearchResult result = SearchResult.found(3);
        assertTrue(result.isFound());
        assertEquals(3, result.getPosition());
    }

    @Test
    @DisplayName("found() com posição zero deve ser válido")
    void foundWithZeroPositionMustBeValid() {
        SearchResult result = SearchResult.found(0);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    @DisplayName("found() deve lançar exceção para posição negativa")
    void foundMustThrowForNegativePosition() {
        assertThrows(IllegalArgumentException.class, () -> SearchResult.found(-1));
    }

    @Test
    @DisplayName("notFound() deve retornar isFound=false e posição -1")
    void notFoundMustReturnIsFFoundFalseAndMinusOne() {
        SearchResult result = SearchResult.notFound();
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }
}
