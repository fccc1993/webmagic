package com.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by fccc on 2017/11/30.
 */

public class DouyuProcessor implements PageProcessor {
    public static final String URL_LIST = "/\\w";
    private Site site = Site
            .me()
//            .setDomain("www.douyu.com")
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(URL_LIST).match()) {
            page.addTargetRequests(page.getHtml().xpath("//div[@class=\"live-list-content\"]").links().regex(URL_LIST).all());
            page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
        } else {
            page.putField("roomTitle", page.getHtml().css(".headline clearfix>h1", "text").all().toString());
//            page.putField("anchor", page.getHtml().xpath("//div[@id='articlebody']//div[@class='articalContent']"));
        }
        }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new DouyuProcessor()).addUrl("https://www.douyu.com/directory/game/DOTA2")
                .addPipeline(new ConsolePipeline()).thread(5).run();
    }
}
