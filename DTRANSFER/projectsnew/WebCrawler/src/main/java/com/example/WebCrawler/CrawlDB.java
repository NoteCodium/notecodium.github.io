package com.example.WebCrawler;

import java.util.HashMap;
import java.util.Map;

public class CrawlDB {
    private static final Map<Integer, CrawlResult> results=
            new HashMap<>();
    //why this is final?, why this is static

    public static void pushResult(CrawlResult crawlResult){
        results.put(crawlResult.getCrawlProcessId(),crawlResult);
    }

    public static CrawlResult getResult(int crawlProcessId){
        return results.get(crawlProcessId);
    }

    public static boolean hasId(int crawlProcessId){
        return results.containsKey(crawlProcessId);
    }

}
