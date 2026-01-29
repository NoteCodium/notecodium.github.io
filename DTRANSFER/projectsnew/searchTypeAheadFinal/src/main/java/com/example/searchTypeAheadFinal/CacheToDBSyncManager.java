package com.example.searchTypeAheadFinal;
//package exceptionhandling.classroom.searchTypeAheadFinal;

import com.example.searchTypeAheadFinal.SuggestionsDataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheToDBSyncManager implements Runnable {

    private final SuggestionsDataStructure dataStructure;

    @Autowired
    public CacheToDBSyncManager(SuggestionsDataStructure suggestionsDataStructure) {
        this.dataStructure = suggestionsDataStructure;
    }

    @Override
    public void run() {
        sync();
    }

    public void sync() {
        while (true) {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("starting to sync...");
            this.dataStructure.reload();
            System.out.println("finished sync...");
        }
    }
}
