package com.ycjw.classicread.model.book;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 笔记实体
 */
@Data
@Entity
public class Note {
    @Id
    private String noteId;

    private String userId;

    /**
     * 记录位置
     */
    private String noteLocation;

    /**
     * 笔记内容
     */
    private String noteInfo;

    /**
     * 记录时间
     */
    private Date noteDate;

    public Note() {
    }

    public Note(String noteId,String userId,String noteLocation,String noteInfo,Date noteDate){
        this.noteId = noteId;
        this.userId = userId;
        this.noteLocation = noteLocation;
        this.noteInfo = noteInfo;
        this.noteDate = noteDate;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNoteLocation() {
        return noteLocation;
    }

    public void setNoteLocation(String noteLocation) {
        this.noteLocation = noteLocation;
    }

    public String getNoteInfo() {
        return noteInfo;
    }

    public void setNoteInfo(String noteInfo) {
        this.noteInfo = noteInfo;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId='" + noteId + '\'' +
                ", noteLocation='" + noteLocation + '\'' +
                ", noteInfo='" + noteInfo + '\'' +
                ", noteDate=" + noteDate +
                '}';
    }
}
