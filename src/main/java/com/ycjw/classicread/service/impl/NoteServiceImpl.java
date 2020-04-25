package com.ycjw.classicread.service.impl;

import com.ycjw.classicread.model.book.Note;
import com.ycjw.classicread.repository.book.NoteDao;
import com.ycjw.classicread.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteDao noteDao;

    @Autowired
    public NoteServiceImpl(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    public Note saveNote(String userId,String chapterId, String noteInfo) {
        Note note = new Note(System.currentTimeMillis() + "",userId,chapterId,noteInfo,new Date());
        return noteDao.save(note);
    }

    @Override
    public List<Note> findAllNote(String userId) {
        return noteDao.findByUserId(userId);
    }

    @Override
    public String deleteNote(String noteId) {
        noteDao.deleteById(noteId);
        return "删除成功";
    }
}
