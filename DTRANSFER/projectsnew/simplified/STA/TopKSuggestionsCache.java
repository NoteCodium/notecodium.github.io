package com.example.searchTypeAheadFinal;//package exceptionhandling.classroom.searchTypeAheadFinal;

import com.example.searchTypeAheadFinal.SuggestionsCache;
import com.example.searchTypeAheadFinal.SuggestionsDataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TopKSuggestionsCache implements SuggestionsCache {

    private final SuggestionsDataStructure dataStructure;

    @Autowired
    public TopKSuggestionsCache(SuggestionsDataStructure suggestionsDataStructure) {
        this.dataStructure = suggestionsDataStructure;
    }

    @Override
    public List<Suggestion> getCachedSuggestions(String query) {
        return this.dataStructure.getTopSuggestions(query);
    }
}
