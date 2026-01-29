package com.example.WebCrawler;

import java.util.ArrayList;
import java.util.List;

public class CrawlResult {
    private final String seedUrl;

    private final int crawlProcessId;

    private CrawlProcessStatus crawlProcessStatus;

    private final List<String> urlsFound;
    //doubt why it is final


    public CrawlResult(String seedUrl, int crawlProcessId) {
        this.seedUrl = seedUrl;
        this.crawlProcessId = crawlProcessId;
        this.crawlProcessStatus = CrawlProcessStatus.IN_PROGRESS;
        this.urlsFound = new ArrayList<>();
    }

    public void addUrl(String url) {
        urlsFound.add(url);
    }

    public List<String> getUrlsFound() {
        return urlsFound;
    }

    public String getSeedUrl() {
        return seedUrl;
    }

    void setCrawlProcessStatus(CrawlProcessStatus crawlProcessStatus) {
        this.crawlProcessStatus = crawlProcessStatus;
    }

    public int getCrawlProcessId() {
        return crawlProcessId;
    }

    public CrawlProcessStatus getCrawlProcessStatus() {
        return crawlProcessStatus;
    }

}
