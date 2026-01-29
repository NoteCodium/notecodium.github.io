package code.src.main.java.lld.examples.eventmgmt;

import java.util.Arrays;
import java.util.List;

public class EventTitle {
    private static final List<String> titles=
        Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
    
    private int cnt=0;

    //so that context switch does not happen during incrementing cnt
    public synchronized void next(){
        cnt=(cnt+1)% titles.size();
    }

    public String get(){
        return titles.get(cnt);
    }


}
