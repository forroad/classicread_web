package com.ycjw.classicread.model.community;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 帖子实体
 */
@Data
@Entity
public class Discuss {
    @Id
    private String discussId;

    /**
     * 社区id
     */
    private String communityId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 发布时间
     */
    private Date publishDate;

    /**
     * 发布内容
     */
    private String discussInfo;

    /**
     * 点赞数
     */
    private int appreciateNum;

    public Discuss() {
    }

    public Discuss(String discussId,String communityId,String userId,Date publishDate,String discussInfo,int appreciateNum){
        this.discussId = discussId;
        this.communityId = communityId;
        this.userId = userId;
        this.publishDate = publishDate;
        this.discussInfo = discussInfo;
        this.appreciateNum = appreciateNum;
    }

    public String getDiscussId() {
        return discussId;
    }

    public void setDiscussId(String discussId) {
        this.discussId = discussId;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getDiscussInfo() {
        return discussInfo;
    }

    public void setDiscussInfo(String discussInfo) {
        this.discussInfo = discussInfo;
    }

    public int getAppreciateNum() {
        return appreciateNum;
    }

    public void setAppreciateNum(int appreciateNum) {
        this.appreciateNum = appreciateNum;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "discussId='" + discussId + '\'' +
                ", communityId='" + communityId + '\'' +
                ", userId='" + userId + '\'' +
                ", publishDate=" + publishDate +
                ", discussInfo='" + discussInfo + '\'' +
                ", appreciateNum=" + appreciateNum +
                '}';
    }
}
