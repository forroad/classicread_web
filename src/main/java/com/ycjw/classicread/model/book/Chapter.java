package com.ycjw.classicread.model.book;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * 章节实体类
 */
@Data
@Entity
public class Chapter {
    /**
     * 章节id
     */
    @Id
    private String chapterId;

    /**
     * 名著id
     */
    private String bookId;

    /**
     * 章节名字
     */
    private String chapterName;

    /**
     * 章节内容
     */
    @ElementCollection
    private List<String> chapterInfo;

    /**
     * 标志第几章
     */
    private int chapterIndex = 0;

    public Chapter() {
    }

    public Chapter(String chapterId,String bookId,String chapterName,List<String> chapterInfo,int chapterIndex){
        this.chapterId = chapterId;
        this.bookId = bookId;
        this.chapterName = chapterName;
        this.chapterInfo = chapterInfo;
        this.chapterIndex = chapterIndex;
    }


    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public List<String> getChapterInfo() {
        return chapterInfo;
    }

    public void setChapterInfo(List<String> chapterInfo) {
        this.chapterInfo = chapterInfo;
    }

    public int getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(int chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterId='" + chapterId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", chapterName='" + chapterName + '\'' +
                ", chapterInfo='" + chapterInfo + '\'' +
                '}';
    }
}
