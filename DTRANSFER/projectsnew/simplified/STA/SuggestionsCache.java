//package exceptionhandling.classroom.searchTypeAheadFinal;
package com.example.searchTypeAheadFinal;
import java.util.List;

public interface SuggestionsCache {
    List<Suggestion> getCachedSuggestions(String query);
}
