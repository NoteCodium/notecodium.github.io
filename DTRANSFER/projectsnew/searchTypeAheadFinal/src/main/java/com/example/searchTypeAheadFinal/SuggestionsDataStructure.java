package com.example.searchTypeAheadFinal;
import java.util.List;

public interface SuggestionsDataStructure {

    void init(int maxSuggestions);

    List<Suggestion> getTopSuggestions(String query);

    void reload(); // near real-time
    // cache(RAM) <==in-sync==> tables(DB)
}
