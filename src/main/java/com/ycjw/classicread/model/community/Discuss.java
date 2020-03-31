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

    public Discuss(String communityId,String userId,Date publishDate,String discussInfo,int appreciateNum){
        this.communityId = communityId;
        this.userId = userId;
        this.publishDate = publishDate;
        this.discussInfo = discussInfo;
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
