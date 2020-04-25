package com.ycjw.classicread.repository.book;

import com.ycjw.classicread.model.book.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterDao extends JpaRepository<Chapter,String> {

    @Query(value = "select chapter.chapterName from Chapter chapter where chapter.bookId=?1 order by chapter.chapterIndex")
    List<String> findAllNameByChapterId(String bookId);

    @Query(value = "select chapter.chapterId from Chapter chapter where chapter.bookId=?1 order by chapter.chapterIndex")
    List<String> findAllIdByBookId(String bookId);
}

