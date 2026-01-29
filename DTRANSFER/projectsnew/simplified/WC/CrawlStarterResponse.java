package com.example.WebCrawler;

public class CrawlStarterResponse {
    private int processId;
    private CrawlProcessStatus status;

    public CrawlStarterResponse(int processId, CrawlProcessStatus status) {
        this.processId = processId;
        this.status = status;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public CrawlProcessStatus getStatus() {
        return status;
    }

    public void setStatus(CrawlProcessStatus status) {
        this.status = status;
    }
}
