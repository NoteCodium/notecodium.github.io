package concurrencyrefractored.NEW.BatchProcess.custom;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

// @RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class Task implements Runnable{

    private final String message;
    private final int initialGapInSecs;
    private final int subsequentGapsInSecs;
    //for one shot task subsequentGapsInSecs is 0
    private long fireTimeInMilliSecs;

    public Task(String message, int initialGapInSecs, int subsequentGapsInSecs) {
        this.message = message;
        this.initialGapInSecs = initialGapInSecs;
        this.subsequentGapsInSecs = subsequentGapsInSecs;
        this.fireTimeInMilliSecs = System.currentTimeMillis() + initialGapInSecs*1000;
    }



    @Override
    public void run() {
        log.info("Task: " + message + " fireTimeInMilliSecs: " + fireTimeInMilliSecs);
    }   

    
}
