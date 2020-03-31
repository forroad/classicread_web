package com.ycjw.classicread.model.book;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * 书架实体类
 */
@Data
@Entity
public class BookRack {
    @Id
    private String bookRackId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 未置顶图书集合
     */
    @ElementCollection
    private List<String> normalBookIds = new ArrayList<>();

    /**
     * 置顶图书集合
     */
    @ElementCollection
    private List<String> specialBookIds = new ArrayList<>();

    public BookRack() {
    }

    public String getBookRackId() {
        return bookRackId;
    }

    public void setBookRackId(String bookRackId) {
        this.bookRackId = bookRackId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getNormalBookIds() {
        return normalBookIds;
    }

    public void setNormalBookIds(List<String> normalBookIds) {
        this.normalBookIds = normalBookIds;
    }

    public List<String> getSpecialBookIds() {
        return specialBookIds;
    }

    public void setSpecialBookIds(List<String> specialBookIds) {
        this.specialBookIds = specialBookIds;
    }

    @Override
    public String toString() {
        return "BookRack{" +
                "bookRackId='" + bookRackId + '\'' +
                ", userId='" + userId + '\'' +
                ", normalBookIds=" + normalBookIds +
                ", specialBookIds=" + specialBookIds +
                '}';
    }
}
