package com.teste.subarray.domain.validation;

import com.teste.subarray.domain.exception.InvalidSearchRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("SearchRequestValidator")
class SearchRequestValidatorTest {

    private SearchRequestValidator validator;

    @BeforeEach
    void setUp() {
        validator = new SearchRequestValidator();
    }

    @Test
    @DisplayName("deve passar quando ambos os arrays são válidos")
    void shouldPassWhenBothArraysAreValid() {
        assertDoesNotThrow(() -> validator.validate(new int[]{1, 2}, new int[]{1}));
    }

    @Test
    @DisplayName("deve lançar exceção quando universe é nulo")
    void shouldThrowWhenUniverseIsNull() {
        assertThrows(InvalidSearchRequestException.class,
                () -> validator.validate(null, new int[]{1}));
    }

    @Test
    @DisplayName("deve lançar exceção quando target é nulo")
    void shouldThrowWhenTargetIsNull() {
        assertThrows(InvalidSearchRequestException.class,
                () -> validator.validate(new int[]{1, 2}, null));
    }

    @Test
    @DisplayName("deve passar para arrays vazios")
    void shouldPassForEmptyArrays() {
        assertDoesNotThrow(() -> validator.validate(new int[]{}, new int[]{}));
    }
}
