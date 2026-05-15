package com.teste.subarray.application.strategy;

public class LinearSearchStrategy implements SubarraySearchStrategy {

    @Override
    public int search(int[] universe, int[] target) {
        if (target.length == 0) return 0;
        if (target.length > universe.length) return -1;

        for (int i = 0; i <= universe.length - target.length; i++) {
            if (matchesAt(universe, target, i)) return i;
        }

        return -1;
    }

    private boolean matchesAt(int[] universe, int[] target, int offset) {
        for (int j = 0; j < target.length; j++) {
            if (universe[offset + j] != target[j]) return false;
        }
        return true;
    }
}
