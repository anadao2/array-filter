package com.teste.subarray.domain.model;

public class SearchResult {

    private static final int NOT_FOUND = -1;

    private final int position;

    private SearchResult(int position) {
        this.position = position;
    }

    public static SearchResult found(int position) {
        if (position < 0) throw new IllegalArgumentException("posição encontrada não pode ser negativa");
        return new SearchResult(position);
    }

    public static SearchResult notFound() {
        return new SearchResult(NOT_FOUND);
    }

    public int getPosition() {
        return position;
    }

    public boolean isFound() {
        return position != NOT_FOUND;
    }
}
