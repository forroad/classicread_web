package com.ycjw.classicread.repository.book;

import com.ycjw.classicread.model.book.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDao extends JpaRepository<Note,String> {
    List<Note> findByUserId(String userId);
}
