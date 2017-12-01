package com.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by fccc on 2017/11/30.
 */

/**
 * http://blog.csdn.net/li6wen9zhi/article/details/51669065
 * CSS/Xpath 选择器demo
 */
public class CnblogProcessor implements PageProcessor {
    public static final String URL_LIST = "https://www\\.cnblogs\\.com/#p\\d+";

    public static final String URL_POST = "http://www\\.cnblogs\\.com/\\w+/p/\\d+\\.html";

    private Site site = Site
            .me()
            .setDomain("www.cnblogs.com")
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    @Override
    public void process(Page page) {
        //列表页
        if (page.getUrl().regex(URL_LIST).match()) {
            page.addTargetRequests(page.getHtml().xpath("//div[@id=\"post_list\"]").links().regex(URL_POST).all());
            page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
            System.out.println(page.getResultItems().getRequest());
            //文章页
        } else {
            page.putField("title", page.getHtml().css(".postTitle>a", "text").all().toString());
            page.putField("author",
                    page.getHtml().css(".postDesc a:nth-of-type(1)","text").all().toString());
            page.putField("date", page.getHtml().css("#post-date","text").all().toString());
            page.putField("read", page.getHtml().css(".postDesc span:nth-of-type(2)","text").all().toString());
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new CnblogProcessor()).addUrl("https://www.cnblogs.com/#p2")
                .addPipeline(new ConsolePipeline()).thread(5).run();
    }
}
