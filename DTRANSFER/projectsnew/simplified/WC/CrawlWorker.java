package com.example.WebCrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class CrawlWorker implements Callable<CrawlResult> {
    private final CrawlResult crawlResult;

    private final int maxDepth;


    //TODO (make the depth variable)
    public CrawlWorker(CrawlResult crawlResult) {
        this.crawlResult = crawlResult;
        this.maxDepth = 1;
    }

    public CrawlWorker(CrawlResult crawlResult, int maxDepth) {
        this.crawlResult = crawlResult;
        this.maxDepth = maxDepth;
    }

    @Override
    //TODO exception handling, study this
    public CrawlResult call() {
        Set<String> visitedUrls = new HashSet<>();
        System.out.println("Crawling Begin");
        int depth=0;
        crawl(crawlResult, crawlResult.getSeedUrl(), visitedUrls, depth);
        System.out.println("Crawling End");
        crawlResult.setCrawlProcessStatus(CrawlProcessStatus.FINISHED);
        return crawlResult;
    }


    public void crawl(CrawlResult crawlResult, String url ,Set<String> visitedUrls, int currDepth) {
        if(currDepth>maxDepth) return;
        System.out.println("new url:   "+ url);
        visitedUrls.add(url);
        crawlResult.addUrl(url);
        try{
            Document document = Jsoup.connect(url).get();
            Elements links = document.select("a[href]");
            for(Element link: links){
                String absoluteUrl = link.absUrl("href");
                if(!visitedUrls.contains(absoluteUrl) && absoluteUrl.startsWith("https://")){
                    crawl(crawlResult,absoluteUrl,visitedUrls,currDepth+1);
                }
            }

        }
        catch (IOException e){
            System.out.println("Failed to crawl:  "+url);
        }
    }
}
