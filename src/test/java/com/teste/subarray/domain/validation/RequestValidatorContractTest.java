package com.teste.subarray.domain.validation;

import com.teste.subarray.domain.exception.InvalidSearchRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Contrato: RequestValidator")
class RequestValidatorContractTest {

    private final RequestValidator validator = new SearchRequestValidator();

    @Test
    @DisplayName("validate() não deve lançar exceção para entradas válidas")
    void validateMustNotThrowForValidInputs() {
        assertDoesNotThrow(() -> validator.validate(new int[]{1, 2}, new int[]{1}));
    }

    @Test
    @DisplayName("validate() deve lançar exceção quando universe é null")
    void validateMustThrowWhenUniverseIsNull() {
        assertThrows(RuntimeException.class, () -> validator.validate(null, new int[]{1}));
    }

    @Test
    @DisplayName("validate() deve lançar exceção quando target é null")
    void validateMustThrowWhenTargetIsNull() {
        assertThrows(RuntimeException.class, () -> validator.validate(new int[]{1}, null));
    }

    @Test
    @DisplayName("validate() deve lançar InvalidSearchRequestException especificamente para null")
    void validateMustThrowInvalidSearchRequestExceptionForNull() {
        assertThrows(InvalidSearchRequestException.class,
                () -> validator.validate(null, null));
    }

    @Test
    @DisplayName("validate() deve aceitar arrays vazios sem lançar exceção")
    void validateMustAcceptEmptyArrays() {
        assertDoesNotThrow(() -> validator.validate(new int[]{}, new int[]{}));
    }
}
