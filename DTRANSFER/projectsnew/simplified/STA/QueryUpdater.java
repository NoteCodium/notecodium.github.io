package com.example.searchTypeAheadFinal;
import com.example.searchTypeAheadFinal.db.FrequencyCount;
import com.example.searchTypeAheadFinal.db.FrequencyCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryUpdater {

    private final FrequencyCountRepository repository;

    @Autowired
    public QueryUpdater(FrequencyCountRepository frequencyCountRepository) {
        this.repository = frequencyCountRepository;
    }

    public synchronized void update(String query) {
        FrequencyCount fc = this.repository.findByQuery(query);
        if (fc != null) {
            FrequencyCount updated = new FrequencyCount();
            updated.setQuery(query);
            updated.setFrequency(fc.getFrequency() + 1);//220
            this.repository.save(updated);
            this.repository.delete(fc);
        } else {
            FrequencyCount newFrequencyCount = new FrequencyCount();
            newFrequencyCount.setQuery(query);
            newFrequencyCount.setFrequency(1);
            this.repository.save(newFrequencyCount);
        }
    }

}
