package com.ycjw.classicread.controller;

import com.ycjw.classicread.service.SpiderSerice;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("spider")
public class SpiderController {
    private SpiderSerice spiderSerice;

    public SpiderController(SpiderSerice spiderSerice) {
        this.spiderSerice = spiderSerice;
    }

    @PostMapping
    public void crawl_bool_data(){
        List<String> urls = new ArrayList<>();
        urls.add("http://www.guojiajiyi.cn/list/6.html");
        urls.add("http://www.guojiajiyi.cn/list/6/2.html");
        urls.add("http://www.guojiajiyi.cn/list/1.html");
        urls.add("http://www.guojiajiyi.cn/list/1/2.html");
        urls.add("http://www.guojiajiyi.cn/list/1/3.html");
        urls.add("http://www.guojiajiyi.cn/list/1/4.html");
        urls.add("http://www.guojiajiyi.cn/list/1/5.html");
        urls.add("http://www.guojiajiyi.cn/list/1/6.html");
        urls.add("http://www.guojiajiyi.cn/list/2.html");
        urls.add("http://www.guojiajiyi.cn/list/3.html");
        urls.add("http://www.guojiajiyi.cn/list/3/2.html");
        urls.add("http://www.guojiajiyi.cn/list/4.html");
        urls.add("http://www.guojiajiyi.cn/list/4/2.html");
        urls.add("http://www.guojiajiyi.cn/list/4/3.html");
        urls.add("http://www.guojiajiyi.cn/list/4/4.html");
        urls.add("http://www.guojiajiyi.cn/list/5.html");
        urls.add("http://www.guojiajiyi.cn/list/5/2.html");
        urls.add("http://www.guojiajiyi.cn/list/5/3.html");
        urls.add("http://www.guojiajiyi.cn/list/5/4.html");
        urls.add("http://www.guojiajiyi.cn/list/5/5.html");
        urls.add("http://www.guojiajiyi.cn/list/5/6.html");
        urls.add("http://www.guojiajiyi.cn/list/5/7.html");
        urls.add("http://www.guojiajiyi.cn/list/5/8.html");
        urls.add("http://www.guojiajiyi.cn/list/5/9.html");
        urls.add("http://www.guojiajiyi.cn/list/5/10.html");
        urls.add("http://www.guojiajiyi.cn/list/5/11.html");
        urls.add("http://www.guojiajiyi.cn/list/5/12.html");
        urls.add("http://www.guojiajiyi.cn/list/5/13.html");
        urls.add("http://www.guojiajiyi.cn/list/5/14.html");
        urls.add("http://www.guojiajiyi.cn/list/5/15.html");
        urls.add("http://www.guojiajiyi.cn/list/5/16.html");
        urls.add("http://www.guojiajiyi.cn/list/5/17.html");
        urls.add("http://www.guojiajiyi.cn/list/5/18.html");
        urls.add("http://www.guojiajiyi.cn/list/5/19.html");
        for(String url:urls){
            spiderSerice.crawl_book_data(url);
        }
    }

    @GetMapping("update")
    public void update_book(){
        spiderSerice.update_book();
    }

    @GetMapping("test")
    public void test(){
        spiderSerice.test();
    }

    @GetMapping("book_bookE")
    public void book_bookE(){
        spiderSerice.book_bookE();
    }
}
