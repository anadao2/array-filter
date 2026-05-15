package com.teste.subarray.domain.port.in;

import com.teste.subarray.domain.model.SearchRequest;
import com.teste.subarray.domain.model.SearchResult;

public interface SubarraySearchUseCase {
    SearchResult search(SearchRequest request);
}
