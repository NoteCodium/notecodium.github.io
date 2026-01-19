package code.src.main.java.lld.examples.matchingalgorithm.mockinterviewplatform;

import java.util.ArrayList;
import java.util.List;

public class InterviewerBucket {
    private static final int NUM_BUCKETS = 10;
    private final List<Node> buckets;

    public InterviewerBucket() {
        this.buckets = new ArrayList<>();
        for(int i = 0; i < NUM_BUCKETS; i++) {
            this.buckets.add(new Node(-1));
        }
    }

    int book (int candId){
        int bktId = getHash(candId);
        Node bkt = buckets.get(bktId);
        synchronized(bkt){
//            while() tough logic
            return 1;
        }

    }

    void free(int candId){

    }

    int getHash(int id){
        return id % NUM_BUCKETS;
    }

}
