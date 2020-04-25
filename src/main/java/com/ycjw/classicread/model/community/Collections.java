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

    public Collections(String collectionsId,String userId,List<String> discussIds){
        this.collectionsId = collectionsId;
        this.userId = userId;
        this.discussIds = discussIds;
    }

    public String getCollectionsId() {
        return collectionsId;
    }

    public void setCollectionsId(String collectionsId) {
        this.collectionsId = collectionsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getDiscussIds() {
        return discussIds;
    }

    public void setDiscussIds(List<String> discussIds) {
        this.discussIds = discussIds;
    }

    public void addDiscussId(String discussId){
        this.discussIds.add(discussId);
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
