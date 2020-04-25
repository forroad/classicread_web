package com.ycjw.classicread.model.community;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 评论
 */
@Data
@Entity
public class Comment {
    @Id
    private String commentId;

    /**
     * 帖子id
     */
    private String discussId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 评论内容
     */
    private String commentInfo;

    /**
     * 点赞数
     */
    private int appreciateNum;

    public Comment() {
    }

    public Comment(String commentId,String discussId,String userId,String commentInfo,int appreciateNum){
        this.commentId = commentId;
        this.discussId = discussId;
        this.userId = userId;
        this.commentInfo = commentInfo;
        this.appreciateNum = appreciateNum;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getDiscussId() {
        return discussId;
    }

    public void setDiscussId(String discussId) {
        this.discussId = discussId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }

    public int getAppreciateNum() {
        return appreciateNum;
    }

    public void setAppreciateNum(int appreciateNum) {
        this.appreciateNum = appreciateNum;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", discussId='" + discussId + '\'' +
                ", userId='" + userId + '\'' +
                ", commentInfo='" + commentInfo + '\'' +
                ", appreciateNum=" + appreciateNum +
                '}';
    }
}
