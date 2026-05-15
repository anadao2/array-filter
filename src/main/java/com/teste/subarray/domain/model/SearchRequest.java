package com.teste.subarray.domain.model;

import java.util.Arrays;
import java.util.Objects;

public class SearchRequest {

    private final int[] universe;
    private final int[] target;

    public SearchRequest(int[] universe, int[] target) {
        Objects.requireNonNull(universe, "universe não pode ser nulo");
        Objects.requireNonNull(target, "target não pode ser nulo");
        this.universe = Arrays.copyOf(universe, universe.length);
        this.target = Arrays.copyOf(target, target.length);
    }

    public int[] getUniverse() {
        return Arrays.copyOf(universe, universe.length);
    }

    public int[] getTarget() {
        return Arrays.copyOf(target, target.length);
    }
}
