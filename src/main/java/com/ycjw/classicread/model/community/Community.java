package com.ycjw.classicread.model.community;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 社区实体
 */
@Data
@Entity
public class Community {
    @Id
    private String communityId;

    /**
     * 名著id
     */
    private String bookId;

    public Community() {
    }

    public Community(String communityId,String bookId){
        this.communityId = bookId;
        this.bookId = bookId;
    }

    

    @Override
    public String toString() {
        return "Community{" +
                "communityId='" + communityId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }
}
