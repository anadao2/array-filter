package com.teste.subarray.adapter.in.cli;

import com.teste.subarray.adapter.config.AppFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("CliAdapter")
class CliAdapterTest {

    private CliAdapter adapter;
    private ByteArrayOutputStream output;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        AppFactory factory = AppFactory.builder()
                .universe(new int[]{0, 2, 3, 5, 7, 9, 11})
                .build();
        adapter = new CliAdapter(
                factory.getUseCase(),
                factory.getRequestFactory(),
                factory.getUniverseRepository()
        );
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("deve imprimir posição correta quando target é encontrado")
    void shouldPrintCorrectPositionWhenTargetFound() {
        adapter.run(new int[]{3, 5});
        assertTrue(output.toString().contains("Resultado: 2"));
    }

    @Test
    @DisplayName("deve imprimir -1 quando target não é encontrado")
    void shouldPrintMinusOneWhenTargetNotFound() {
        adapter.run(new int[]{2, 5});
        assertTrue(output.toString().contains("Resultado: -1"));
    }

    @Test
    @DisplayName("deve imprimir labels de Universo e Objetivo na saída")
    void shouldPrintUniverseAndObjective() {
        adapter.run(new int[]{2, 3});
        String out = output.toString();
        assertTrue(out.contains("Universo:"));
        assertTrue(out.contains("Objetivo:"));
    }

    @Test
    @DisplayName("deve imprimir 0 quando target está no início do universo")
    void shouldPrintZeroWhenTargetAtStart() {
        adapter.run(new int[]{0, 2});
        assertTrue(output.toString().contains("Resultado: 0"));
    }
}
