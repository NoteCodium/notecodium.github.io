package com.example.WebCrawler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crawl")
public class CrawlController {
    @Autowired
    private CrawlManager crawlManager;

//    @PostMapping("/start")
    //or
    @RequestMapping(method= RequestMethod.POST, value="/start")
    public CrawlStarterResponse startCrawling(@RequestBody CrawlStarterRequest crawlStarterRequest) {
        if(crawlStarterRequest.getSeedUrl() == null || crawlStarterRequest.getSeedUrl().isEmpty())
            throw new RuntimeException("seed url is empty");
        CrawlResult crawlResult = crawlManager.startCrawling(crawlStarterRequest.getSeedUrl());
        return new CrawlStarterResponse(crawlResult.getCrawlProcessId(), crawlResult.getCrawlProcessStatus());
    }


    @RequestMapping(method= RequestMethod.GET, value="/results")
    public CrawlResult getCrawlResult(@RequestParam("id") int crawlProcessId) {
        if(crawlProcessId <= 0)
            throw new RuntimeException("invalid id");
        return crawlManager.getResult(crawlProcessId);
    }


}
