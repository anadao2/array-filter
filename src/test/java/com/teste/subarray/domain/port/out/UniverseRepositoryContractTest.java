package com.teste.subarray.domain.port.out;

import com.teste.subarray.infrastructure.repository.InMemoryUniverseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Contrato: UniverseRepository")
class UniverseRepositoryContractTest {

    private final UniverseRepository repository =
            new InMemoryUniverseRepository(new int[]{0, 2, 3, 5, 7});

    @Test
    @DisplayName("load() nunca deve retornar null")
    void loadMustNeverReturnNull() {
        assertNotNull(repository.load());
    }

    @Test
    @DisplayName("load() deve retornar os mesmos dados em chamadas sucessivas")
    void loadMustBeIdempotent() {
        assertArrayEquals(repository.load(), repository.load());
    }

    @Test
    @DisplayName("load() deve aceitar universo vazio sem lançar exceção")
    void loadMustAcceptEmptyUniverse() {
        UniverseRepository empty = new InMemoryUniverseRepository(new int[]{});
        assertNotNull(empty.load());
        assertEquals(0, empty.load().length);
    }
}
