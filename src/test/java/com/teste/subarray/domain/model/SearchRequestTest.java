package com.teste.subarray.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("SearchRequest")
class SearchRequestTest {

    @Test
    @DisplayName("getUniverse() deve retornar cópia defensiva — não a mesma referência")
    void getUniverseMustReturnDefensiveCopy() {
        int[] universe = {1, 2, 3};
        SearchRequest request = new SearchRequest(universe, new int[]{1});
        assertNotSame(universe, request.getUniverse());
        assertArrayEquals(universe, request.getUniverse());
    }

    @Test
    @DisplayName("getTarget() deve retornar cópia defensiva — não a mesma referência")
    void getTargetMustReturnDefensiveCopy() {
        int[] target = {1, 2};
        SearchRequest request = new SearchRequest(new int[]{1, 2, 3}, target);
        assertNotSame(target, request.getTarget());
        assertArrayEquals(target, request.getTarget());
    }

    @Test
    @DisplayName("mutação externa do array original não deve afetar o SearchRequest")
    void externalMutationMustNotAffectRequest() {
        int[] universe = {1, 2, 3};
        SearchRequest request = new SearchRequest(universe, new int[]{1});
        universe[0] = 99;
        assertArrayEquals(new int[]{1, 2, 3}, request.getUniverse());
    }

    @Test
    @DisplayName("mutação do array retornado pelo getter não deve afetar o SearchRequest")
    void mutationOfReturnedArrayMustNotAffectRequest() {
        SearchRequest request = new SearchRequest(new int[]{1, 2, 3}, new int[]{1});
        request.getUniverse()[0] = 99;
        assertArrayEquals(new int[]{1, 2, 3}, request.getUniverse());
    }

    @Test
    @DisplayName("construtor deve lançar NullPointerException quando universe é null")
    void constructorMustThrowWhenUniverseIsNull() {
        assertThrows(NullPointerException.class, () -> new SearchRequest(null, new int[]{1}));
    }

    @Test
    @DisplayName("construtor deve lançar NullPointerException quando target é null")
    void constructorMustThrowWhenTargetIsNull() {
        assertThrows(NullPointerException.class, () -> new SearchRequest(new int[]{1}, null));
    }
}
