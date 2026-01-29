package com.example.searchTypeAheadFinal;
import com.example.searchTypeAheadFinal.db.FrequencyCount;
import com.example.searchTypeAheadFinal.db.FrequencyCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.lang.Math.min;
@Component
public class Trie implements SuggestionsDataStructure {

    private volatile TrieNode root; // mul threads
    private final FrequencyCountRepository repository;
    private int k = Constants.MAX_SUGGESTIONS_LIMIT;

    @Autowired
    public Trie(FrequencyCountRepository frequencyCountRepository, Optional<Integer> maxSugg) {
        this.root = new TrieNode();
        this.repository = frequencyCountRepository;
        init(maxSugg.isEmpty() ? k : maxSugg.get());
        //doubt at present
    }

    @Override
    public void init(int maxSuggestions) {
        // code to fetch data from DB
        k = Math.max(k, maxSuggestions);
        constructTrie(root);
        /**insert("apple", 5, 0, root);
        insert("appley", 4, 0, root);
        insert("applex", 10, 0, root);
        insert("applexe", 7, 0, root);
        insert("applexoy", 2, 0, root);
        insert("applexoyo", 9, 0, root);

        insert("appla", 15, 0, root);
        insert("applo", 18, 0, root);

        insert("appy", 22, 0, root);
        insert("appe", 8, 0, root);
        insert("appo", 80, 0, root);

        insert("apt", 100, 0, root);
        insert("app", 79, 0, root);

        insert("ap", 105, 0, root);
        insert("apartment", 1050, 0, root);**/

    }

    private void constructTrie(TrieNode root) {
        List<FrequencyCount> frequencyCounts =
                this.repository.findAll();// to read records from DB
        // one by one insert those in trie
        for (FrequencyCount fc : frequencyCounts) {
            insert(fc.getQuery(), fc.getFrequency(), 0, root);
        }
    }

    public List<Suggestion> insert(String query, int frequency, int idx, TrieNode curr) {
        if (idx == query.length() || idx == Constants.MAX_QUERY_SIZE)  { // Termination condition
            Set<Suggestion> suggestions =
                    new HashSet<>(curr.getTopSuggestions());
            suggestions.add(new Suggestion(query, frequency));
            return updateSuggestionsAndGet(suggestions, curr);
        }
        if (curr.getPointers().get(query.charAt(idx) - 'a') == null) {
            curr.getPointers().set(query.charAt(idx) - 'a', new TrieNode());
        }
        TrieNode next = curr.getPointers().get(query.charAt(idx) - 'a');
        Set<Suggestion> allSuggestions = new HashSet<>();
        if (idx == query.length() - 1) {
            next.setEOW(true);
        }
        insert(query, frequency, idx+1, next);// r(s1,s2,s3)
        allSuggestions.addAll(curr.getTopSuggestions());
        for (int i = 0; i < 26; i++) {
            TrieNode node = curr.getPointers().get(i);
            if (node != null) {
                allSuggestions.addAll(node.getTopSuggestions());
            }
        }
        return updateSuggestionsAndGet(allSuggestions, curr);
    }


    @Override
    public List<Suggestion> getTopSuggestions(String query) { //"ap"
        TrieNode curr = root;
        int i = 0;
        List<Suggestion> ans = new ArrayList<>();
        while (true) {
            curr = curr.getPointers().get(query.charAt(i)-'a');
            if (curr == null)
                return ans;
            i++;
            if (i == query.length())
                return curr.getTopSuggestions();
        }
    }


    private List<Suggestion> updateSuggestionsAndGet(Set<Suggestion> suggestions, TrieNode curr) {
        List<Suggestion> allSuggestionsList = new ArrayList<>();
        allSuggestionsList.addAll(suggestions);
        Collections.sort(allSuggestionsList, new Comparator<Suggestion>() {
            @Override
            public int compare(Suggestion o1, Suggestion o2) {
                return o2.getFrequency() - o1.getFrequency();
            }
        });
        List<Suggestion> finalSuggestions = new ArrayList<>();
        for (int i = 0; i < min(k, allSuggestionsList.size()); i++) {
            finalSuggestions.add(allSuggestionsList.get(i));
        }
        curr.setTopSuggestions(finalSuggestions);
        return curr.getTopSuggestions();
    }


    @Override
    public void reload() {
        TrieNode temp = new TrieNode();
        constructTrie(temp);
        root = temp;
    }
    //where is the multithreadung code
     //    "" (s1:5, s2:9)
    //    /                \
    //   "a"(s3:17,s4:23)   "d"(s1:5, s2:9) czeckoslavakia






}
