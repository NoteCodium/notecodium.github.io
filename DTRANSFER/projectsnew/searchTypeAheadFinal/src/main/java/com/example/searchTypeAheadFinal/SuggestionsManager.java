package com.example.searchTypeAheadFinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuggestionsManager {

    private final SuggestionsCache suggestionsCache;

    @Autowired
    public SuggestionsManager(SuggestionsCache suggestionsCache) {
        this.suggestionsCache = suggestionsCache;
    }

    public List<Suggestion> getSuggestions(String query) {
        if (query.length() > Constants.MAX_QUERY_SIZE)
            throw new RuntimeException("length out of limit");
        query = query.toLowerCase(); // and other logics specific to manager
        return this.suggestionsCache.getCachedSuggestions(query);
    }

}
