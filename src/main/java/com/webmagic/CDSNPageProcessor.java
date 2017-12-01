package com.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fccc on 2017/11/29.
 */

public class CDSNPageProcessor implements PageProcessor {
    //    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
//            .setHttpProxy(new HttpHost("192.168.0.47", 8080))
//            .setUsernamePasswordCredentials(new UsernamePasswordCredentials("CDSN_XU", "xfc19930602"));
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    @Override
    public void process(Page page) {
        List<String> list = new ArrayList<String>();

        for (int i = 2; i < 700; i++) {
            list.add("http://bbs.csdn.net/forums/Java_WebDevelop?page=" + i);
        }

        page.addTargetRequests(list);
        page.putField("title", page.getHtml().css(".title>a", "text").all().toString());
    }

    /**
     * get the site settings
     *
     * @return site
     * @see Site
     */
    @Override
    public Site getSite() {
        return site;
    }


    public static void main(String[] args) {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(new Proxy("192.168.0.47", 8080, "CDSN_XU", "xfc19930602")));
        Spider.create(new CDSNPageProcessor())
                //设置采集的起始页面
                .addUrl("http://bbs.csdn.net/forums/Java_WebDevelop")
//                .setDownloader(httpClientDownloader)
                //输出
                .addPipeline(new ConsolePipeline()).thread(5).run();
    }
}