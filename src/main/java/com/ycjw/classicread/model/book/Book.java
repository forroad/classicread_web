package com.ycjw.classicread.model.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 名著实体类
 */
@Document(indexName = "classicread",type = "book")
public class Book {
    /**
     * 名著Id
     */
    @Id
    private String bookId;

    /**
     * 书名名字
     */
    private String bookName;

    /**
     * 作者
     */
    private String bookAuthor;

    /**
     * 章节id集合
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> chapterIds = new ArrayList<>();

    private String firstChapter = "";/**
     * 第一章内容，作简介用
     */

    /**
     * 上次阅读时间
     */
    private Date lastRead;

    /**
     * 收藏数
     */
    private int collectionNum;

    /**
     * 图书封面储存路径
     */
    private String bookImgPath;

    public Book() {
    }

    public Book(String bookId, String bookName, String bookAuthor, List<String> chapterIds, int collectionNum, String bookImgPath){
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.chapterIds = chapterIds;
        this.collectionNum = collectionNum;
        this.bookImgPath = bookImgPath;
    }

    public Book(Book book){
        this.bookId = book.getBookId();
        this.bookName = book.getBookName();
        this.bookAuthor = book.getBookAuthor();
        this.chapterIds = book.getChapterIds();
        this.collectionNum = book.getCollectionNum();
        this.bookImgPath = book.getBookImgPath();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<String> getChapterIds() {
        return chapterIds;
    }

    public void setChapterIds(List<String> chapterIds) {
        this.chapterIds = chapterIds;
    }

    public int getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(int collectionNum) {
        this.collectionNum = collectionNum;
    }

    public String getBookImgPath() {
        return bookImgPath;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookImgPath(String bookImgPath) {
        this.bookImgPath = bookImgPath;
    }

    public void addChapterId(String chapterId){
        this.chapterIds.add(chapterId);
    }

    public String getFirstChapter() {
        return firstChapter;
    }

    public Date getLastRead() {
        return lastRead;
    }

    public void setLastRead(Date lastRead) {
        this.lastRead = lastRead;
    }

    public void setFirstChapter(String firstChapter) {
        this.firstChapter = firstChapter;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", chapterIds=" + chapterIds +
                ", collectionNum=" + collectionNum +
                ", bookImgPath='" + bookImgPath + '\'' +
                '}';
    }
}
