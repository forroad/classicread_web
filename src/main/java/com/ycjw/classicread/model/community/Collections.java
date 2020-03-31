package com.ycjw.classicread.model.community;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * 收藏夹
 */
@Data
@Entity
public class Collections {
    @Id
    private String collectionsId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 收藏的帖子id集合
     */
    @ElementCollection
    private List<String> discussIds = new ArrayList<>();

    public Collections() {
    }

    public Collections(String userId,List<String> discussIds){
        this.userId = userId;
        this.discussIds = discussIds;
    }

    @Override
    public String toString() {
        return "Collections{" +
                "collectionsId='" + collectionsId + '\'' +
                ", userId='" + userId + '\'' +
                ", discussIds=" + discussIds +
                '}';
    }
}
