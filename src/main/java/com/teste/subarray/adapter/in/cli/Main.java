package com.teste.subarray.adapter.in.cli;

import com.teste.subarray.adapter.config.AppFactory;

public class Main {

    public static void main(String[] args) {
        AppFactory factory = AppFactory.builder()
                .universe(new int[]{0, 2, 3, 5, 7, 9, 11})
                .build();

        CliAdapter adapter = new CliAdapter(
                factory.getUseCase(),
                factory.getRequestFactory(),
                factory.getUniverseRepository()
        );

        adapter.run(new int[]{3, 5});
        adapter.run(new int[]{2, 5});
    }
}
