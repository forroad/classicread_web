package com.ycjw.classicread.controller;

import com.ycjw.classicread.model.book.Note;
import com.ycjw.classicread.service.NoteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("saveNote")
    public Note saveNote(String userId, String chapterId, String noteInfo){
        return noteService.saveNote(userId,chapterId,noteInfo);
    }

    @PostMapping("findAllNote")
    public List<Note> findAllNote(String userId){
        return noteService.findAllNote(userId);
    }

    @PostMapping("deleteNote")
    public String deleteNote(String noteId){
        return noteService.deleteNote(noteId);
    }
}
