package com.ycjw.classicread.service;

import com.ycjw.classicread.model.book.Note;

import java.util.List;

public interface NoteService {

    Note saveNote(String userId,String chapterId,String noteInfo);

    List<Note> findAllNote(String userId);

    String deleteNote(String noteId);
}
