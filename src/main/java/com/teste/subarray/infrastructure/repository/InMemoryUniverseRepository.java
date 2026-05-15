package com.teste.subarray.infrastructure.repository;

import com.teste.subarray.domain.port.out.UniverseRepository;

import java.util.Arrays;

public class InMemoryUniverseRepository implements UniverseRepository {

    private final int[] data;

    public InMemoryUniverseRepository(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    @Override
    public int[] load() {
        return Arrays.copyOf(data, data.length);
    }
}
