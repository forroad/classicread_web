package com.ycjw.classicread.service;

public interface SpiderSerice {
    /**
     * 爬取网页名著数据
     * @param url 包含名著信息的url
     */
    void crawl_book_data(String url);

    void update_book();

    void test();
}
