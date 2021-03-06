package com.ycjw.classicread.service.impl;

import com.ycjw.classicread.model.book.Book;
import com.ycjw.classicread.model.book.Chapter;
import com.ycjw.classicread.repository.book.BookDao;
import com.ycjw.classicread.repository.book.ChapterDao;
import com.ycjw.classicread.service.SpiderSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.collections.IteratorUtils;

import org.springframework.transaction.annotation.Transactional;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

@Service
@Transactional
public class SpiderServiceImpl implements SpiderSerice {
    private BookDao bookDao;
    private ChapterDao chapterDao;

    @Autowired
    public SpiderServiceImpl(BookDao bookDao, ChapterDao chapterDao) {
        this.bookDao = bookDao;
        this.chapterDao = chapterDao;
    }

//    @Override
//    public void crawl_book_data(String url) {
//        Random random = new Random();
//        /**
//         * 解析普通章节内容
//         */
//        class ChapterInfoProcessor implements PageProcessor{
//            private Site site = Site.me().setRetryTimes(3).setSleepTime(2000);
//            private String chapterId;
//
//            public ChapterInfoProcessor(String chapterId) {
//                this.chapterId = chapterId;
//            }
//
//            @Override
//            public void process(Page page) {
//                /**
//                 * 获取章节内容
//                 */
//                List<String> chapterInfos = page.getHtml().xpath("//div[@class='panel-body']/p/text()").all();
//
//                Chapter chapter = chapterDao.findById(chapterId).get();
//                chapter.setChapterInfo(chapterInfos);
//
//                chapterDao.save(chapter);
//            }
//
//            @Override
//            public Site getSite() {
//                return site;
//            }
//        }
//
//        /**
//         * 解析现代章节内容
//         */
//        class ChapterInfoProcessorXiandai implements PageProcessor{
//            private Site site = Site.me().setRetryTimes(3).setSleepTime(2000);
//            private String chapterId;
//
//
//            public ChapterInfoProcessorXiandai(String chapterId) {
//                this.chapterId = chapterId;
//            }
//
//            @Override
//            public void process(Page page) {
//                /**
//                 * 获取章节内容
//                 */
//                String chapterInfo = page.getHtml().xpath("//div[@class='panel-body']/p").get();
//                chapterInfo = chapterInfo.replace("<p>","");
//                chapterInfo = chapterInfo.replace("</p>","");
//                String[] chapterInfos = chapterInfo.split("<br><br>");
//
//
//                Chapter chapter = chapterDao.findById(chapterId).get();
//                chapter.setChapterInfo(Arrays.asList(chapterInfos));
//
//                chapterDao.save(chapter);
//            }
//
//            @Override
//            public Site getSite() {
//                return site;
//            }
//        }
//
//        /**
//         * 解析诗词章节内容
//         */
//        class ChapterInfoProcessorShici implements PageProcessor{
//            private Site site = Site.me().setRetryTimes(3).setSleepTime(2000);
//            private String chapterId;
//
//
//            public ChapterInfoProcessorShici(String chapterId) {
//                this.chapterId = chapterId;
//            }
//
//            @Override
//            public void process(Page page) {
//                /**
//                 * 获取章节内容
//                 */
//                String chapterInfo = page.getHtml().xpath("//div[@class='panel-body']").get();
//                chapterInfo = chapterInfo.replace("<div class=\"panel-body\" id=\"htmlContent\">","");
//                chapterInfo = chapterInfo.replace("</div>","");
//                String[] chapterInfos = chapterInfo.split("<br>");
//
//
//                Chapter chapter = chapterDao.findById(chapterId).get();
//                chapter.setChapterInfo(Arrays.asList(chapterInfos));
//
//                chapterDao.save(chapter);
//            }
//
//            @Override
//            public Site getSite() {
//                return site;
//            }
//        }
//
//        /**
//         * 解析章节信息
//         */
//        class ChapterProcessor implements PageProcessor{
//            private Site site = Site.me().setRetryTimes(3).setSleepTime(2000);
//            private String bookId;
//
//            public ChapterProcessor(String bookId) {
//                this.bookId = bookId;
//            }
//
//            @Override
//            public void process(Page page) {
//                /**
//                 * 获取图书封面
//                 */
//                List<String> bookImgUrl = page.getHtml().xpath("//div[@class='panel panel-default']/div[@class='panel-body']/div[@class='row']/div[@class='col-md-2 col-xs-4 hidden-xs']/img/@src").all();
//                /**
//                 * 获取章节名和章节url
//                 */
//                List<String> chapterUrls = page.getHtml().xpath("//dl[@class='panel-body panel-chapterlist']/dd[@class='col-md-3']/a/@abs:href").all();
//                List<String> chapterNames = page.getHtml().xpath("//dl[@class='panel-body panel-chapterlist']/dd[@class='col-md-3']/a/text()").all();
//
//                Book book = bookDao.findById(bookId).get();
//                book.setBookImgPath(bookImgUrl.get(0));
//
//                for(int i = 0;i < chapterUrls.size();i++){
//                    Chapter chapter = new Chapter(String.valueOf(System.currentTimeMillis() + random.nextInt(10000)),bookId,chapterNames.get(i),new ArrayList<>(),i + 1);
//                    chapter = chapterDao.save(chapter);
//                    book.addChapterId(chapter.getChapterId());
//                    bookDao.save(book);
//                    Chapter finalChapter = chapter;
//                    int finalI = i;
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            if(url.contains("www.guojiajiyi.cn/list/5")){
//                                Spider.create(new ChapterInfoProcessorXiandai(finalChapter.getChapterId()))
//                                        .addUrl(chapterUrls.get(finalI))
//                                        .addPipeline(new ConsolePipeline())
//                                        .thread(12)
//                                        .run();
//                            }else if(url.contains("www.guojiajiyi.cn/list/3")){
//                                Spider.create(new ChapterInfoProcessorShici(finalChapter.getChapterId()))
//                                        .addUrl(chapterUrls.get(finalI))
//                                        .addPipeline(new ConsolePipeline())
//                                        .thread(12)
//                                        .run();
//                            }else {
//                                Spider.create(new ChapterInfoProcessor(finalChapter.getChapterId()))
//                                        .addUrl(chapterUrls.get(finalI))
//                                        .addPipeline(new ConsolePipeline())
//                                        .thread(12)
//                                        .run();
//                            }
//
//                        }
//                    }).start();
//                }
//            }
//
//            @Override
//            public Site getSite() {
//                return site;
//            }
//        }
//
//        /**
//         * 解析图书信息
//         */
//        class BookProcessor implements PageProcessor{
//            private Site site = Site.me().setRetryTimes(3).setSleepTime(2000);
//
//            @Override
//            public void process(Page page) {
//                {
//                    /**
//                     * 获取图书名和作者
//                     */
//                    List<String> bookNames = page.getHtml().xpath("//table[@class='table']/tbody/tr/td/a[@class!='text-muted']/text()").all();
//                    List<String> authors = page.getHtml().xpath("//table[@class='table']/tbody/tr/td[@class='text-muted']/text()").all();
//                    List<String> bookUrls = page.getHtml().xpath("//table[@class='table']/tbody/tr/td/a[@class!='text-muted']/@abs:href").all();
//                    for (int i = 0;i < bookNames.size();i++){
//                        Book book = new Book(String.valueOf(System.currentTimeMillis() + random.nextInt(10000)),bookNames.get(i),authors.get(i),new ArrayList<String>(),0,bookUrls.get(i));
//                        book = bookDao.save(book);
//                        Book finalBook = book;
//                        int finalI = i;
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Spider.create(new ChapterProcessor(finalBook.getBookId()))
//                                        .addUrl(bookUrls.get(finalI))
//                                        .addPipeline(new ConsolePipeline())
//                                        .thread(12)
//                                        .run();
//                            }
//                        }).start();
//                    }
//                }
//            }
//
//            @Override
//            public Site getSite() {
//                return site;
//            }
//        }
//
//        Spider.create(new BookProcessor())
//                .addUrl(url)
//                .addPipeline(new ConsolePipeline())
//                .thread(12)
//                .run();
//    }
//
//
//
//    @Override
//    public void update_book() {
//        List<Book> books = bookDao.findAll();
//        for(Book book:books){
//            if(book.getChapterIds().size() > 0){
//                try {
//                    Chapter chapter = chapterDao.findById(book.getChapterIds().get((0))).orElse(new Chapter());
//                    List<String> chapter_info = chapter.getChapterInfo();
//                    if(chapter_info.size() > 0){
//                        book.setFirstChapter(chapter_info.get(0));
//                        bookDao.save(book);
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                    continue;
//                }
//            }
//        }
//        System.out.println("更新完成");
//    }
//
//    @Override
//    public void test() {
//        /**
//         * 解析章节内容
//         */
//        class ChapterInfoProcessor implements PageProcessor{
//            private Site site = Site.me().setRetryTimes(3).setSleepTime(2000);
//
//
//            @Override
//            public void process(Page page) {
//
//                writetxt(page.getHtml().toString());
//                /**
//                 * 获取章节内容
//                 */
//                String chapterInfo = page.getHtml().xpath("//div[@class='panel-body']").get();
//                chapterInfo = chapterInfo.replace("<div class=\"panel-body\" id=\"htmlContent\">","");
//                chapterInfo = chapterInfo.replace("</div>","");
//                String[] chapterInfos = chapterInfo.split("<br>");
//                System.out.println(Arrays.toString(chapterInfos));
//            }
//
//            @Override
//            public Site getSite() {
//                return site;
//            }
//        }
//
//
//        Spider.create(new ChapterInfoProcessor())
//                .addUrl("http://www.guojiajiyi.cn/w393/16009.html")
//                .addPipeline(new ConsolePipeline())
//                .thread(12)
//                .run();
//    }

    @Override
    public void crawl_book_data(String url) {

    }

    @Override
    public void update_book() {
        List<Book> books = IteratorUtils.toList(bookDao.findAll().iterator());
        for (Book book:books){
            if(!book.getBookImgPath().endsWith("jpg")){
                bookDao.delete(book);
                continue;
            }
            List<Chapter> chapters = chapterDao.findByBookIdAndChapterIndex(book.getBookId(),1);
            if(chapters == null) continue;
            try {
                book.setFirstChapter(chapters.get(0).getChapterInfo().get(0));
                bookDao.save(book);
            }catch (Exception e){
                e.printStackTrace();
                book.setFirstChapter(book.getBookAuthor() + "最新力作" + book.getBookName() + ",欢迎观看！");
                bookDao.save(book);
                continue;
            }

        }
        System.out.println("更新完成");
    }

    @Override
    public void test() {

    }

    @Override
    public void book_bookE() {
//        List<Book> books = bookDao.findAll();
//        for(Book book:books){
//            bookDao.save(new Book(book));
//        }
//        System.out.println("转换完成");
    }

    private void writetxt(String text){
        try {
            /* 写入Txt文件 */
            File writename = new File("C:\\Users\\17127\\Desktop\\log.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(text); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
