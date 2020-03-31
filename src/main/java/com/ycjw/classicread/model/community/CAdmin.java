package com.ycjw.classicread.model.community;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 社区版主
 */
@Data
@Entity
public class CAdmin {
    @Id
    private String cadminId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 社区id
     */
    private String communityId;

    public CAdmin() {
    }

    public CAdmin(String userId,String communityId){
        this.userId = userId;
        this.communityId = communityId;
    }

    @Override
    public String toString() {
        return "CAdmin{" +
                "cadminId='" + cadminId + '\'' +
                ", userId='" + userId + '\'' +
                ", communityId='" + communityId + '\'' +
                '}';
    }
}
